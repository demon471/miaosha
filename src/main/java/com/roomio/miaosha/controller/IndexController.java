package com.roomio.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
/**
 * @author biqiang
 * @version 2021/4/14
 * @Description:
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping(value = "/list")
    public String findList(ModelMap model) {
        model.addAttribute("words","this is find list method");
        return "page/index";
    }

}
