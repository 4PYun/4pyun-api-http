package com.pyun.http.api.consts;

/**
 * 固定车类型
 */
public interface ParkingVIPType {

    /**
     * 月卡
     */
    short Month = 1;
    /**
     * 储值车
     */
    short Prepaid = 2;
    /**
     * 储次车
     */
    short PreTimes = 3;
    /**
     * 储天车
     */
    short PreDays = 4;
    /**
     * 年卡
     */
    short Year = 5;
    /**
     * 季度卡
     */
    short Quarter = 6;
    /**
     * 免费停车
     */
    short Free = 0;
}
