package com.roomio.miaosha.controller;

import com.roomio.miaosha.domain.User;
import com.roomio.miaosha.redis.UserKey;
import com.roomio.miaosha.result.CodeMsg;
import com.roomio.miaosha.result.Result;
import com.roomio.miaosha.service.RedisService;
import com.roomio.miaosha.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author biqiang
 * @version 2021/4/16
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger( TestController.class );

    @Autowired
    UserService service;

    @Autowired
    RedisService redisService;

    @GetMapping("/list")
    public String getindex(ModelMap modelMap){
        modelMap.put("words","this is new page");
        logger.debug("bebuginfo","debugggggggg!");
        logger.error("errorinfo","errorrrrrrrrrrrrrrrrrrr!");
        logger.info("info","infoooooooooo!");
        logger.warn("warninfo","warnnnnnnnnnnnnn!");
        User user= service.getuserById(1);

        return "page/index";
    }

    @GetMapping("/user")
    public String getUser(ModelMap modelMap) {
        User user = service.getuserById(1);
        modelMap.put("username", user.getName());
        return "page/index1.html";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    @ResponseBody
    public Result<User> hello() {
        User user = service.getuserById(1);
        return Result.success(user);
    }

    @RequestMapping(value = "/helloerror",method = RequestMethod.POST)
    @ResponseBody
    public Result<User> helloerror() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping(value = "/tx",method = RequestMethod.POST)
    @ResponseBody
    public Boolean tx() {
        service.insert();
        return true;
    }


    @RequestMapping(value = "/testredis",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> testredis() {
        User u1= new User(1,"zhangsan",17);
        User u2= new User(2,"lisi",27);
        redisService.set(UserKey.getById,""+u1.getId(),u1);
        redisService.set(UserKey.getById,""+u2.getId(),u2);

        return Result.success(true);
    }

}
