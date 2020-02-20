package com.pyun.http.api.consts;

/**
 * 车类
 */
public interface CarType {

    short Unknown = 0;
    /**
     * 临停车辆
     */
    short Temporary = 1;
    /**
     * 包月车辆
     */
    short Monthly = 2;
    /**
     * 贵宾/免费车辆
     */
    short Visitant = 3;
    /**
     * 储值车辆
     */
    short Prepaid = 4;
}
