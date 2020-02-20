package com.pyun.http.api.consts;

/**
 * 支付类型
 */
public interface PayType {

    /**
     * 其他未知
     */
    short Unknown = -1;

    /**
     * 现金支付
     */
    short Cash = 1;
    /**
     * 在线支付(场中支付)
     */
    short Online = 2;
    /**
     * 自动支付
     */
    short Prepaid = 3;
    /**
     * 储值余额支付
     */
    short Balance = 4;
}
