package com.pyun.http.api.consts;

/**
 * 接口应答状态码
 */
public interface ResultCode {

    /**
     * 接口处理成功
     */
    String OK = "1001";
    /**
     * 参数错误
     */
    String ILLEGAL_ARGUMENT = "1400";
    /**
     * 访问拦截
     */
    String ACCESS_DENY = "1401";
    /**
     * 内部错误错误
     */
    String INTERNAL_ERROR = "1500";
    /**
     * 服务暂不可用
     */
    String SERVICE_UNAVAILABLE = "1503";

}
