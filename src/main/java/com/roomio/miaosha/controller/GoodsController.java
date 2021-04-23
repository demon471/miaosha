package com.roomio.miaosha.controller;

import com.roomio.miaosha.domain.MiaoshaUser;
import com.roomio.miaosha.service.GoodsService;
import com.roomio.miaosha.service.MiaoshaUserService;
import com.roomio.miaosha.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author biqiang
 * @version 2021/4/22
 * @Description:商品
 * @Copyright (C)2021, Pcitech
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger( LoginController.class );


    @Autowired
    MiaoshaUserService service;

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/to_list",method = {RequestMethod.GET})
    public String to_list(ModelMap modelMap,
//                          @CookieValue(value = MiaoshaUserService.COOKI_NAME_TOKEN,required = false) String cookieToken,
//                          @RequestParam(value = MiaoshaUserService.COOKI_NAME_TOKEN,required = false) String paramToken,
                            HttpServletResponse response,MiaoshaUser user){
     /*  if(StringUtils.isEmpty(cookieToken)&&StringUtils.isEmpty(paramToken)){
           return "page/login";
       }
       String token=StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
      MiaoshaUser miaoshaUser= service.getByToken(token,response);
      modelMap.put("user",miaoshaUser);*/
        modelMap.put("user",user);
        //查询产品列表
        List<GoodsVo> listgoodvo =goodsService.getGoodsVoList();
        modelMap.put("goodslist",listgoodvo);
        return "page/goods_list";
    }

    @RequestMapping(value = "/to_detail/{goodsId}" ,method = RequestMethod.GET)
    public String to_detail(ModelMap modelMap, MiaoshaUser user, @PathVariable("goodsId") Integer goodsId) {
        modelMap.put("user",user);
        GoodsVo goods= goodsService.getGoodVoById(goodsId);
        Long startAt=goods.getStartDate().getTime();
        Long endAt=goods.getEndDate().getTime();
        Long now= System.currentTimeMillis();

        int remainSeconds=0;

        int miaoshaStatus=0;

        if(now<startAt){//秒杀未开始
            miaoshaStatus=0;
            remainSeconds=(int)((startAt-now)/1000);
        }else if(now>startAt){//已经结束
            miaoshaStatus=2;
            remainSeconds=-1;
        }else{//秒杀正在进行中
            miaoshaStatus=1;
            remainSeconds=0;
        }
        modelMap.put("goods",goods);
        modelMap.put("remainSeconds",remainSeconds);
        modelMap.put("miaoshaStatus",miaoshaStatus);
        return "page/goods_detail";
    }

}
