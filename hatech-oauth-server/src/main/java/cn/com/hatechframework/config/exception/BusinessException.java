package cn.com.hatechframework.config.exception;

import cn.com.hatechframework.utils.response.ResponseCode;
import lombok.Getter;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.exception
 * @className BusinessException
 * @description 自定义业务异常
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/20 17:03             1.0                         自定义业务异常
 */
@Getter
public class BusinessException extends RuntimeException {
    private final Integer code;

    /**
     *  自定义业务异常
     * @param errorCode  响应状态枚举类
     * @author WangMingShuai
     * @date 2019/12/24 16:16
     * @return
     */
    public BusinessException(ResponseCode errorCode) {
      super(errorCode.message());
      this.code = errorCode.code();
    }

    /**
     *  自定义业务异常
     * @param code  异常码
     * @param message  异常码描述
     * @author WangMingShuai
     * @date 2019/12/24 16:17
     * @return
     */
    public BusinessException(Integer code, String message) {
      super(message);
      this.code = code;
    }

    /**
     *  自定义业务异常
     * @param errorCode  响应状态枚举类
     * @param message  异常码描述
     * @author WangMingShuai
     * @date 2019/12/24 16:17
     * @return
     */
    public BusinessException(ResponseCode errorCode, String message) {
        super(message);
        this.code = errorCode.code();
    }

}
