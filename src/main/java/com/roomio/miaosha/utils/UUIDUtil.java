package com.roomio.miaosha.utils;

import java.util.UUID;

/**
 * @author biqiang
 * @version 2021/4/22
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
public class UUIDUtil {
    public static  String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
