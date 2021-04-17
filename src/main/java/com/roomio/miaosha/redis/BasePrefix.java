package com.roomio.miaosha.redis;

/**
 * @author roomio
 * @version 2021/4/18
 * @Description:
 * @Copyright (C)2021
 */
public abstract class BasePrefix implements KeyPrefix{

    private int expireSeconds;

    private String prefix;


    public BasePrefix(String prefix) {
       this(0,prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {//默认0为永不过期
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className=getClass().getSimpleName();
        return className+":"+prefix;
    }
}
