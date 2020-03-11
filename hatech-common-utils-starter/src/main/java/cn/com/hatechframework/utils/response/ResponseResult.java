package cn.com.hatechframework.utils.response;


/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils.response
 * @className ResponseResult
 * @description 响应状态结果信息实体类
 * @author JiangXincan
 * @create 2019/12/18 9:43
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 9:43             1.0                         响应状态结果信息实体类
 */
public class ResponseResult {

    private ResponseResult(){}

    /**
     * @description 返回处理结果
     *
     * 针对于返回业务处理之后，无需通知前端具体处理信息，走系统默认的提示信息
     *
     * @Param <T> 响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success() {
        return new ResponseObject(ResponseCode.REQUEST_SUCCESS);
    }

    /**
     * @description 返回处理结果
     *
     * 针对于返回业务处理之后，需要向前端反馈后台处理的数据，将其返回
     *
     * @param responseCode   响应状态
     * @param data           响应数据
     * @author JiangXincan
     * @date 2019/12/20 14:41
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(ResponseCode responseCode, T data) {
        return new ResponseObject<T>(responseCode)
                .count(1)
                .data(data);
    }

    /**
     * @description 返回处理结果
     *
     * 针对于返回业务处理之后，需要向前端反馈后台处理的数据，将其返回
     *
     * @Param data      响应数据
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(T data) {
        return new ResponseObject<T>(ResponseCode.REQUEST_SUCCESS)
                .count(1)
                .data(data);
    }

    /**
     * @description 返回处理结果
     *
     * 针对于返回业务处理之后，需要向前端反馈后台处理的数据，并且将处理结果描述提供给前端
     *
     * @Param message   响应结果描述
     * @Param data      响应数据
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(String message, T data) {
        return new ResponseObject<T>()
                .code(ResponseCode.REQUEST_SUCCESS)
                .msg(message)
                .count(1)
                .data(data);
    }


    /**
     * @description 返回分页数据信息
     *
     * （数据分页）针对于返回业务处理之后，需要向前端反馈后台处理分页的数据，
     *  并携带状态、数据总条数、系统默认处理信息
     *
     * @Param total     响应数据条数
     * @Param data      响应数据
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(long total, T data){
        return new ResponseObject<T>(ResponseCode.REQUEST_SUCCESS)
                .count(total)
                .data(data);
    }

    /**
     * @description 返回分页数据信息
     *
     * （数据分页）针对于返回业务处理之后，需要向前端反馈后台处理分页的数据，
     *  并携带状态、数据总条数、自定义处理信息
     *
     * @Param message   响应结果信息
     * @Param total     响应数据条数
     * @Param data      响应数据
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(String message, long total, T data){
        return new ResponseObject<T>()
                .code(ResponseCode.REQUEST_SUCCESS)
                .msg(message)
                .count(total)
                .data(data);
    }

    /**
     * @description 返回分页数据信息
     *
     * @Param code      响应结果编码
     * @Param message   响应结果信息
     * @Param data      响应数据
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(int code, String message, T data){
        return new ResponseObject<T>()
                .code(code)
                .msg(message)
                .count(0)
                .data(data);
    }

    /**
     * @description 返回分页数据信息
     *
     * @Param code      响应结果编码
     * @Param message   响应结果信息
     * @Param total     响应数据条数
     * @Param data      响应数据
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(int code, String message, long total, T data){
        return new ResponseObject<T>()
                .code(code)
                .msg(message)
                .count(total)
                .data(data);
    }

    /**
     * @description 返回处理结果
     *
     * 针对于返回业务处理之后，需要向前端反馈后台处理的数据，将其返回
     *
     * @param responseCode   响应状态
     * @param total          响应数据条数
     * @param data           响应数据
     * @author JiangXincan
     * @date 2019/12/20 14:41
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(ResponseCode responseCode, long total, T data) {
        return new ResponseObject<T>(responseCode)
                .count(total)
                .data(data);
    }

    /*****************************************************************************/

    /**
     * @description 返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默认返回失败处理信息
     *
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error() {
        return new ResponseObject<T>(ResponseCode.REQUEST_ERROR)
                .count(0)
                .msg(ResponseCode.REQUEST_ERROR.message())
                .data(null);
    }

    /**
     * @description 返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默认返回失败处理信息
     *
     * @Param responseCode      响应状态
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(ResponseCode responseCode) {
        return new ResponseObject<T>(responseCode)
                .count(0)
                .msg(responseCode.message())
                .data(null);
    }

    /**
     * @description 返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默认返回失败处理信息
     *
     * @Param responseCode      响应状态
     * @Param data              响应数据
     * @Param <T>               响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(ResponseCode responseCode, T data) {
        return new ResponseObject<T>(responseCode)
                .count(0)
                .data(data);
    }

    /**
     * @description 返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默返回自定义失败处理信息
     *
     * @Param message   响应结果信息
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(String message) {
        return new ResponseObject<T>()
                .code(ResponseCode.REQUEST_ERROR)
                .msg(message)
                .count(0)
                .data(null);
    }

    /**
     * @description 返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默返回自定义失败处理信息并返回传入修改的信息
     *
     * @Param message   响应结果信息
     * @Param data      响应数据
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(String message, T data) {
        return new ResponseObject<T>()
                .code(ResponseCode.REQUEST_ERROR)
                .msg(message)
                .count(0)
                .data(data);
    }

    /**
     * @description 返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默返回自定义失败处理信息并返回传入修改的信息
     *
     * @Param message   响应结果信息
     * @Param data      响应数据
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(Integer code, String message) {
        return new ResponseObject<T>()
                .code(code)
                .msg(message)
                .count(0)
                .data(null);
    }

    /**
     * @description 返回处理结果
     *
     * token过期传入code,或其他的错误传入code值
     *
     * @Param code      响应结果编码
     * @Param message   响应结果信息
     * @Param data      响应数据
     * @Param <T>       响应数据类型
     * @author JiangXincan
     * @date 2019/12/17 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(Integer code, String message, T data) {
        return new ResponseObject<T>()
                .code(code)
                .msg(message)
                .count(0)
                .data(data);
    }

}
