package com.roomio.miaosha.redis;

/**
 * @author roomio
 * @version 2021/4/18
 * @Description:expireSeconds:有效期  getPrefix：前缀
 * @Copyright (C)2021
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
