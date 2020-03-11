package cn.com.hatechframework.config.log;

import cn.com.hatechframework.entity.center.log.dto.SystemLogSaveDTO;
import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.server.feign.IFSystemLogService;
import cn.com.hatechframework.server.feign.IFUserDetailsService;
import cn.com.hatechframework.utils.context.BaseContextHandler;
import cn.com.hatechframework.utils.network.IpUtil;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseObject;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.log
 * @className OptionLogAspect
 * @description 操作日志记录切面类
 * @author YeMeng
 * @create 2019/12/25 18:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/25 18:09             1.0                         操作日志记录切面类
 */
@Component
@Slf4j
@Aspect
public class OptionLogAspect {

    /**
     * 获取微服务名称
     */
    @Value("${spring.application.name}")
    private String microService;

    /**
     * 获取微服务端口号
     */
    @Value("${server.port}")
    private Integer microServicePort;

    /**
     * 用户详情feign接口
     */
    private final IFUserDetailsService fUserDetailsService;

    /**
     * 系统日志feign接口
     */
    private final IFSystemLogService fSystemLogService;

    public OptionLogAspect(IFUserDetailsService fUserDetailsService, IFSystemLogService fSystemLogService) {
        this.fUserDetailsService = fUserDetailsService;
        this.fSystemLogService = fSystemLogService;
    }

    /**
     *  日志切点
     * @author YeMeng
     * @date 2020/1/6 17:10
     * @return void
     */
    @Pointcut("@annotation(cn.com.hatechframework.config.log.OptionLog)")
    private void logPointcut() {
        // 日志切点
    }

    /**
     *  环绕触发 在所有标注@OptionLog的地方切入
     * @param joinPoint  日志切点
     * @author YeMeng
     * @date 2020/1/6 17:10
     * @return java.lang.Object
     */
    @Around(value = "logPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable { //常见日志实体对象
        // 返回信息
        Object object = joinPoint.proceed();

        // 拦截的方法参数类型
        Signature signature = joinPoint.getSignature();

        if (!(signature instanceof MethodSignature)) {
            log.error("{}", "该注解只能用于方法");
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        MethodSignature methodSignature = (MethodSignature) signature;

        // 拦截的实体类，就是当前正在执行的controller
        Object target = joinPoint.getTarget();
        // 获得被拦截的方法
        Method function = target.getClass().getMethod(
                joinPoint.getSignature().getName(),
                methodSignature.getMethod().getParameterTypes()
        );

        // 不需要拦截直接返回
        if (function == null) {
            return object;
        }

        // 判断扫描该函数是否包含自定义的log日志注解
        if (!function.isAnnotationPresent(OptionLog.class)) {
            return object;
        }

        // 保存日志信息
        save(function, joinPoint);

        return object;
    }

    /**
     *  保存日志信息
     * @param function  方法
     * @param joinPoint 切点
     * @author YeMeng
     * @date 2020/1/6 17:09
     * @return void
     */
    private void save(Method function, ProceedingJoinPoint joinPoint) throws UnknownHostException {

        // 获取注解类
        OptionLog optionLog = function.getAnnotation(OptionLog.class);

        //获取ApiOperation注解类
        ApiOperation apiOperation = function.getAnnotation(ApiOperation.class);
        String description = apiOperation.value() + "--" + apiOperation.notes();

        // 获取controller类中对应接口的路径
        String controllerUri = joinPoint.getSignature().getDeclaringTypeName();

        // 获取controller中注解的值
        String controllerAnnInfo = getControllerAnnInfo(controllerUri);

        // 拦截方法路径
        String classUrl = controllerUri + "." + joinPoint.getSignature().getName();

        // 拦截的方法参数
        String classParam = null;
        Object[] param = joinPoint.getArgs();
        if (param.length > 0) {
            classParam = JSON.toJSONString(param);
        }
        // 获取服务器IP
        InetAddress address = IpUtil.getLocalHostLanAddress();
        String username = BaseContextHandler.getUserName();
        String tenantName = BaseContextHandler.getTenantName();
        SystemLogSaveDTO systemLogSaveDTO = SystemLogSaveDTO.builder()
                // 当前系统操作用户
                .userName(username)
                // 租户
                .tenantId(tenantName)
                // 当前系统操作主机IP
                .ip(address.getHostAddress())
                // 当前系统微服务端口号
                .port(microServicePort)
                // 当前系统微服务名称
                .microService(microService)
                // 当前系统类请求路径
                .classUrl(classUrl)
                // 当前系统类请求参数
                .classParam(classParam)
                // 当前系统操作类型（增删改查等等）
                .type(optionLog.type())
                // 当前系统操作业务的日志分类
                .businessType(optionLog.businessType())
                // 当前系统操作的模块名称
                .model(controllerAnnInfo)
                // 当前系统操作说明
                .description(description)
                .build();

        ResponseObject<UserVO> userInfo = fUserDetailsService.findUserByUsername(username, tenantName);
        if (userInfo.getCode() == ResponseCode.REQUEST_SUCCESS.code()) {
            UserVO userVO = userInfo.getData();
            systemLogSaveDTO.setUserId(userVO.getId());
            // 当前系统操作用户所属公司
            systemLogSaveDTO.setCompany(userVO.getCompany());
            // 当前系统操作用户所在部门
            systemLogSaveDTO.setDepartment(userVO.getOrganizationId());
        }
        else {
            systemLogSaveDTO.setUserId("-");
            // 当前系统操作用户所属公司
            systemLogSaveDTO.setCompany("-");
            // 当前系统操作用户所在部门
            systemLogSaveDTO.setDepartment("-");
        }
        fSystemLogService.save(systemLogSaveDTO);
    }

    /**
     * @param controllerUri
     * @Method getControllerAnnInfo
     * @author WangTong
     * @Version 1.0
     *  获取controller类中注解的内容
     * @Return java.lang.String
     * @Exception
     * @Date 2019/3/20 17:50
     */
    @SuppressWarnings("all")
    private String getControllerAnnInfo(String controllerUri) {
        try {
            Class clazz = Class.forName(controllerUri);
            Api api = (Api) clazz.getAnnotation(Api.class);
            String[] value = api.tags();
            //将字符串数组转成字符串
            StringBuilder sb = new StringBuilder();
            for (String ele : value) {
                sb.append("-" + ele);
            }
            String classPath = sb.toString();
            return classPath.substring(1);
        } catch (ClassNotFoundException e) {
            log.error("模块名称为空", e);
            return "模块名称为空";
        }
    }

}
