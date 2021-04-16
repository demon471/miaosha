package com.roomio.miaosha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("/list")
    public String getindex(ModelMap modelMap){
        modelMap.put("words","this is new page");
        logger.debug("bebuginfo","debugggggggg!");
        logger.error("errorinfo","errorrrrrrrrrrrrrrrrrrr!");
        logger.info("info","infoooooooooo!");
        logger.warn("warninfo","warnnnnnnnnnnnnn!");
        return "page/index";
    }
}
