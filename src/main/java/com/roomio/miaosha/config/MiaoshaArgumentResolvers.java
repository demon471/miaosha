package com.roomio.miaosha.config;

import com.roomio.miaosha.domain.MiaoshaUser;
import com.roomio.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author biqiang
 * @version 2021/4/22
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
@Service
public class MiaoshaArgumentResolvers implements HandlerMethodArgumentResolver {

    @Autowired
    MiaoshaUserService service;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> clazz= methodParameter.getParameterType();
        return clazz== MiaoshaUser.class;
        //判断class类型是MiaoshaUser才走下面的方法
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request= nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response=nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        String paramToken = request.getParameter(MiaoshaUserService.COOKI_NAME_TOKEN);
        String cookieToken = getCookieToken(request,MiaoshaUserService.COOKI_NAME_TOKEN);
        if(StringUtils.isEmpty(cookieToken)&&StringUtils.isEmpty(paramToken)){
            return null;
        }
        String token=StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        return service.getByToken(token,response);
    }

    private String getCookieToken(HttpServletRequest request, String cookiNameToken) {
        Cookie[]  cookies =request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookiNameToken.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return null;
    }
}
