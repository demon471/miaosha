package com.roomio.miaosha.controller;

import com.roomio.miaosha.result.CodeMsg;
import com.roomio.miaosha.result.Result;
import com.roomio.miaosha.service.MiaoshaUserService;
import com.roomio.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


/**
 * @author biqiang
 * @version 2021/4/21
 * @Description: 测试登录
 * @Copyright (C)2021, Pcitech
 */

@Controller
@RequestMapping(value="/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger( LoginController.class );

    @Autowired
    private MiaoshaUserService service;

    @RequestMapping(value = "/to_login",method = {RequestMethod.GET})
    public String to_login(){
        return "page/login";
    }

    @RequestMapping(value = "/do_login",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> do_login(@Valid LoginVo loginVo){
           logger.info(loginVo.toString());
             /*String inputPass=loginVo.getPassword();
            String mobile=loginVo.getMobile();
            if(StringUtils.isEmpty(inputPass)){
                return Result.error(CodeMsg.PASSWORD_EMPTY);
            }
            if(StringUtils.isEmpty(mobile)){
                return Result.error(CodeMsg.MOBILE_EMPTY);
            }*/
            service.login(loginVo);
            return Result.success(true);
    }
}
