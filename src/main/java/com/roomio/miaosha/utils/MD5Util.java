package com.roomio.miaosha.utils;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author biqiang
 * @version 2021/4/21
 * @Description:MD5加密类
 * @Copyright (C)2021, Pcitech
 */
@Component
public class MD5Util {

    private static String MD5SALT="1a2b3c4d";

    /*@NacosValue("${MD5SALT}")
    private String salt;

    @PostConstruct
    public  void  getApiToken(){
        MD5SALT=this.salt;
    }*/

    public static String  md5en(String src){
        return DigestUtils.md5Hex(src);
    }

    public static String inputPassToFormPass(String inputPass){
        String str=""+MD5SALT.charAt(0)+MD5SALT.charAt(2)+inputPass+MD5SALT.charAt(5)+MD5SALT.charAt(4);
        return md5en(str);
    }

    public static String FormPassToDBPass(String formPass,String salt){
        String str=""+MD5SALT.charAt(0)+MD5SALT.charAt(2)+formPass+MD5SALT.charAt(5)+MD5SALT.charAt(4);
        return md5en(str);
    }

    public static String inputPassToDBPass(String input,String DBsalt){
        return FormPassToDBPass(inputPassToFormPass(input),DBsalt);
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("123456"));
//        System.out.println(FormPassToDBPass(inputPassToFormPass("123456"),"asdq13231"));d3b1294a61a07da9b49b6e22b2cbd7f9
//
//        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));

    }

}
