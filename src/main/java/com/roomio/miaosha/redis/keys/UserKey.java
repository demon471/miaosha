package com.roomio.miaosha.redis.keys;

import com.roomio.miaosha.redis.BasePrefix;

/**
 * @author roomio
 * @version 2021/4/18
 * @Description:
 * @Copyright (C)2021
 */
public class UserKey extends BasePrefix {

    public UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");

    public static UserKey getByName = new UserKey("name");
}
