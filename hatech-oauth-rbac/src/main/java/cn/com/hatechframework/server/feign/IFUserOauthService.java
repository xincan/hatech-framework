package cn.com.hatechframework.server.feign;

import cn.com.hatechframework.entity.oauth.server.dto.OAuthParamDTO;
import cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO;
import cn.com.hatechframework.server.feign.factory.FUserOauthServiceFallbackFactory;
import cn.com.hatechframework.utils.response.ResponseObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.feign
 * @className IFUserOauthService
 * @description 用户登陆认证feign接口
 * @author WangMingShuai
 * @create 2019/12/18 16:38
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/18 16:38             1.0                         用户登陆认证
 */
@FeignClient(name = "HATECH-OAUTH-SERVER",
        contextId = "userOauthService",
        fallbackFactory = FUserOauthServiceFallbackFactory.class)
@Component("userOauthService")
public interface IFUserOauthService {

    /**
     * 用户登陆
     * @param oAuthParamDTO
     * @author WangMingShuai
     * @date 2019/12/30 19:05
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @PostMapping(value = "/user/login")
    ResponseObject userLogin (@RequestBody OAuthParamDTO oAuthParamDTO);

    /**
     * 用户退出
     * @author WangMingShuai
     * @date 2019/12/30 19:05
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @PostMapping("/user/logout")
    ResponseObject logout();


    /**
     * 查询所有租户数据源
     * @author YeMeng
     * @date 2019/12/27 13:41
     * @return cn.com.hatechframework.utils.response.ResponseObject<cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO>
     */
    @GetMapping("/tenant/datasource")
    ResponseObject<List<TenantDataSourceVO>> findAllTenantDataSource();

}
