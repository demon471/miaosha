package com.roomio.miaosha.service;

import com.roomio.miaosha.dao.MiaoshaDao;
import com.roomio.miaosha.domain.MiaoshaUser;
import com.roomio.miaosha.result.CodeMsg;
import com.roomio.miaosha.utils.MD5Util;
import com.roomio.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author biqiang
 * @version 2021/4/21
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
@Service
public class MiaoshaUserService {
    @Autowired
    private MiaoshaDao miaoshaDao;

    public MiaoshaUser getMiaoshaUserById(Long id){
        return miaoshaDao.getMiaoshaUserById(id);
    }

    public CodeMsg login(LoginVo loginVo) {
        if (loginVo==null){
            return  CodeMsg.SERVER_ERROR;
        }
       String mobile=loginVo.getMobile();
        String formPass= loginVo.getPassword();
       //判断手机号是否存在
        MiaoshaUser user=getMiaoshaUserById(Long.parseLong(mobile));
        if (user==null){
            return CodeMsg.PEOPLE_NOTEXIST;
        }
        //验证密码
        String dbPass=user.getPassword();
        String dbsalt=user.getSalt();
        String calcaPass= MD5Util.FormPassToDBPass(formPass,dbPass);
        if(!calcaPass.equals(dbPass)){
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;
    }
}
