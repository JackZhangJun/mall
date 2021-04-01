package com.zhangjun.mall.common.api;

public class CommonResult<T> {

    private long code;

    private String message;

    private T data;

    public CommonResult() {
    }

    /**
     *
     * @param code
     * @param message
     * @param data
     */
    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data)
    {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }


    /**
     *
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data,String message)
    {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     *
     * @param errorCode
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode)
    {
        return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    /**
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(String message)
    {
        return new CommonResult<T>(ResultCode.FAILED.getCode(),message,null);
    }


    /**
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed()
    {
        return failed(ResultCode.FAILED);
    }

    /**
     *参数验证失败返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed()
    {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 未登录返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unauthorized(T data)
    {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),data);
    }

    /**
     * 未授权返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> forbidden(T data)
    {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(),data);
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
