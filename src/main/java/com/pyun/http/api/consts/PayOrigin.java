package com.pyun.http.api.consts;

/**
 * 支付来源
 */
public interface PayOrigin {

    /**
     * PYun到账
     */
    short PYun = 0;
    /**
     * 支付宝直接到账
     */
    short Alipay = 4;
    /**
     * 微信直接到账
     */
    short WeChat = 8;
}
