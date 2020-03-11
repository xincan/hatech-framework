package cn.com.hatechframework.config.exception;

import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.netflix.client.ClientException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.exception
 * @className GlobalExceptionHandler
 * @description 全局异常处理
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/20 17:03             1.0                         全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String MISSING_REQUEST_BODY = "Required request body is missing";
    private static final String JSON_PARSE_EXCEPTION = "JsonParseException";
    private static final String INVALID_FORMAT_EXCEPTION = "InvalidFormatException";
    /**类型不匹配*/
    private static final String TYPE_MISMATCH = "typeMismatch";

    /**
     *  捕获 404 异常处理
     * @param exception NoHandlerFoundException 404 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseObject handlerNoHandlerFoundException(NoHandlerFoundException exception) {
        outPutErrorWarn(NoHandlerFoundException.class, ResponseCode.NOT_FOUND, exception);
        return ResponseResult.error(ResponseCode.NOT_FOUND);
    }

    /**
     *  捕获 405 异常处理
     * @param exception HttpRequestMethodNotSupportedException 405 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseObject handlerHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException exception) {
        outPutErrorWarn(HttpRequestMethodNotSupportedException.class,
                ResponseCode.METHOD_NOT_ALLOWED, exception);
        return ResponseResult.error(ResponseCode.METHOD_NOT_ALLOWED);
    }

    /**
     *  捕获 415 异常处理
     * @param exception HttpMediaTypeNotSupportedException 415 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseObject handlerHttpMediaTypeNotSupportedException(
            HttpMediaTypeNotSupportedException exception) {
        outPutErrorWarn(HttpMediaTypeNotSupportedException.class,
                ResponseCode.UNSUPPORTED_MEDIA_TYPE, exception);
        return ResponseResult.error(ResponseCode.UNSUPPORTED_MEDIA_TYPE);
    }

    /**
     *  捕获 500 异常处理
     * @param exception Exception 500 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseObject handlerException(Exception exception) {
        return ifDepthExceptionType(exception);
    }

    /**
     *  捕获 FeignException 异常处理
     * @param exception FeignException 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(value = FeignException.class)
    public ResponseObject handlerFeignException(FeignException exception) {
        outPutError(FeignException.class, ResponseCode.RPC_ERROR, exception);
        return ResponseResult.error(ResponseCode.RPC_ERROR);
    }

    /**
     *  捕获 RPC 异常处理
     * @param exception ClientException 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(value = ClientException.class)
    public ResponseObject handlerClientException(ClientException exception) {
        outPutError(ClientException.class, ResponseCode.RPC_ERROR, exception);
        return ResponseResult.error(ResponseCode.RPC_ERROR);
    }

    /**
     *  捕获 参数错误异常 添加了 @RequestParam 却没有传递参数
     * @param exception MissingServletRequestParameterException 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseObject handleMissingServletRequestParameterException (MissingServletRequestParameterException exception) {
        String filedName = exception.getParameterName();
        return ResponseResult.error(ResponseCode.PARAM_ERROR.code(), "未传递参数 " + filedName);
    }

    /**
     *  捕获 参数错误异常 （@RequestBody）属性类型错误
     * @param exception HttpMessageNotReadableException 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseObject handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        outPutError(HttpMessageNotReadableException.class, ResponseCode.PARAM_ERROR, exception);
        String message = exception.getMessage();
        log.info("{}","@RequestBody 但是为传递任何参数");
        if (!StringUtils.isEmpty(message) && message.contains(MISSING_REQUEST_BODY) ) {
            return ResponseResult.error(ResponseCode.PARAM_ERROR.code(), "缺少请求主体,请传入JSON类型请求主体");
        }
        log.info("{}","@RequestBody 传递参数但不是json类型，比如随便写了一个字符串");
        if (!StringUtils.isEmpty(message) && message.contains(JSON_PARSE_EXCEPTION) ) {
            return ResponseResult.error(ResponseCode.PARAM_ERROR.code(), "请求主体格式错误,请传入JSON类型");
        }
        log.info("{}","@RequestBody 传递参数但在转换对象时出现类型转换异常");
        if (!StringUtils.isEmpty(message) && message.contains(INVALID_FORMAT_EXCEPTION) ) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) exception.getCause();
            String filedName = invalidFormatException.getPath().get(0).getFieldName();
            return ResponseResult.error(ResponseCode.PARAM_ERROR.code(), filedName + "属性，格式错误");
        }
        String msg = String.format("%s : 错误详情( %s )", ResponseCode.PARAM_ERROR.message(),
                exception.getRootCause().getMessage());
        return ResponseResult.error(ResponseCode.PARAM_ERROR.code(), msg);
    }

    /**
     *  捕获 参数错误异常
     * @param exception ConstraintViolationException 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseObject handleConstraintViolationException(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        if (constraintViolations.isEmpty()) {
            log.error("validExceptionHandler 错误 fieldErrors 为是空");
            ResponseResult.error(ResponseCode.BUSINESS_ERROR.code(), "");
        }

        return ResponseResult.error(ResponseCode.PARAM_ERROR.code(), "ConstraintViolationException错误");
    }

    /**
     *  捕获 参数错误异常（@RequestBody） org.springframework.validation
     * @param exception MethodArgumentNotValidException 异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseObject handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return getBindResultDTO(bindingResult);
    }

    /**
     *  捕获 参数错误异常（非@RequestBody） org.springframework.validation
     * @param exception BindException 属性校验异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(BindException.class)
    public ResponseObject handleBindException(BindException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return getBindResultDTO(bindingResult);
    }

    /**
     *  捕获 自定义业务异常
     * @param exception BusinessException 自定义业务异常
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseObject handlerBusinessException(BusinessException exception) {
        return ResponseResult.error(exception.getCode(), exception.getMessage());
    }

    /**
     *  处理 BindingResult 异常
     * @param bindingResult org.springframework.validation校验信息
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    private ResponseObject getBindResultDTO(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (fieldErrors.isEmpty()) {
            log.error("validExceptionHandler 错误 fieldErrors 为空");
            ResponseResult.error(ResponseCode.BUSINESS_ERROR.code(), "");
        }

        FieldError fieldError = fieldErrors.get(0);
        if (TYPE_MISMATCH.equals(fieldError.getCode())) {
            return ResponseResult.error(ResponseCode.PARAM_ERROR.code(), fieldError.getField() + "属性，格式错误");
        }
        return ResponseResult.error(ResponseCode.PARAM_ERROR.code(), fieldError.getDefaultMessage());
    }

    /**
     *  二次深度检查错误类型
     * @param throwable 异常信息
     * @author WangMingShuai
     * @date 2019/12/24 16:21
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    private ResponseObject ifDepthExceptionType(Throwable throwable) {
        Throwable cause = throwable.getCause();
        if (cause instanceof ClientException) {
            return handlerClientException((ClientException) cause);
        }
        if (cause instanceof FeignException) {
            return handlerFeignException((FeignException) cause);
        }
        outPutError(Exception.class, ResponseCode.EXCEPTION, throwable);
        return ResponseResult.error(ResponseCode.EXCEPTION);
    }

    /**
     *  错误日志打印
     * @param errorType          错误类型
     * @param secondaryErrorType 二次错误类型
     * @param throwable          错误信息
     * @author WangMingShuai
     * @date 2019/12/24 16:34
     * @return void
     */
    private void outPutError(Class errorType, Enum secondaryErrorType, Throwable throwable) {
        log.error("{} {}: {}", errorType.getSimpleName(), secondaryErrorType, throwable.getMessage(),
                throwable);
    }

    /**
     *  告警日志打印
     * @param errorType          错误类型
     * @param secondaryErrorType 二次错误类型
     * @param throwable          错误信息
     * @author WangMingShuai
     * @date 2019/12/24 16:34
     * @return void
     */
    private void outPutErrorWarn(Class errorType, Enum secondaryErrorType, Throwable throwable) {
        log.warn("{} {}: {}", errorType.getSimpleName(), secondaryErrorType, throwable.getMessage());
    }

}
