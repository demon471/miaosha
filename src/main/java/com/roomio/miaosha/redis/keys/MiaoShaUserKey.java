package com.roomio.miaosha.redis.keys;

import com.roomio.miaosha.redis.BasePrefix;

/**
 * @author biqiang
 * @version 2021/4/22
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
public class MiaoShaUserKey extends BasePrefix {

    public static final  int TOKEN_EXPIRE=3600*24*2;

    public MiaoShaUserKey(int expireSeconds,String prefix) {
        super(expireSeconds,prefix);
    }

    public static MiaoShaUserKey token = new MiaoShaUserKey(TOKEN_EXPIRE,"tk");

}
