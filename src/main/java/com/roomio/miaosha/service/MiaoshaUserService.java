package com.roomio.miaosha.service;

import com.roomio.miaosha.dao.MiaoshaDao;
import com.roomio.miaosha.domain.MiaoshaUser;
import com.roomio.miaosha.exception.GlobalException;
import com.roomio.miaosha.redis.keys.MiaoShaUserKey;
import com.roomio.miaosha.result.CodeMsg;
import com.roomio.miaosha.utils.MD5Util;
import com.roomio.miaosha.utils.UUIDUtil;
import com.roomio.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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

    @Autowired
    private  RedisService redisService;

    public static final String COOKI_NAME_TOKEN="token";

    public MiaoshaUser getMiaoshaUserById(Long id){
        return miaoshaDao.getMiaoshaUserById(id);
    }

    public boolean login(HttpServletResponse response , LoginVo loginVo) {
        if (loginVo==null){
            throw  new GlobalException(CodeMsg.SERVER_ERROR) ;
        }
       String mobile=loginVo.getMobile();
        String formPass= loginVo.getPassword();
       //判断手机号是否存在
        MiaoshaUser user=getMiaoshaUserById(Long.parseLong(mobile));
        if (user==null){
            throw  new GlobalException(CodeMsg.PEOPLE_NOTEXIST);
        }
        //验证密码
        String dbPass=user.getPassword();
        String dbsalt=user.getSalt();
        String calcaPass= MD5Util.FormPassToDBPass(formPass,dbsalt);
        if(!calcaPass.equals(dbPass)){
            throw  new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        String token = UUIDUtil.uuid();
         addToken(user,token,response);
        return true;
     }

    public  void addToken(MiaoshaUser user,String token,HttpServletResponse response){
        redisService.set(MiaoShaUserKey.token,token,user);
        Cookie cookie= new Cookie(COOKI_NAME_TOKEN,token);
        cookie.setMaxAge(MiaoShaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public MiaoshaUser getByToken(String token,HttpServletResponse response) {
        if(StringUtils.isEmpty(token)){
            return null;
        }
        MiaoshaUser user= redisService.get(MiaoShaUserKey.token,token,MiaoshaUser.class);
        if (user!=null){
            //延长用户登录有效期
            addToken(user,token,response);
        }
        return user;
    }
}
