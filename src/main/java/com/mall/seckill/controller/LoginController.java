package com.mall.seckill.controller;

import com.mall.seckill.cache.RedisService;
import com.mall.seckill.cache.SeckillUserKey;
import com.mall.seckill.domain.SeckillUser;
import com.mall.seckill.result.Result;
import com.mall.seckill.service.SeckillUserService;
import com.mall.seckill.util.UUIDUtil;
import com.mall.seckill.vo.LoginUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SeckillUserService seckillUserService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginUserVo loginUserVo) {
        SeckillUser seckillUser = seckillUserService.login(loginUserVo);
        String uuid = UUIDUtil.uuid();
        redisService.set(SeckillUserKey.token, uuid, seckillUser);
        Cookie cookie = new Cookie("loginToken", uuid);
        cookie.setMaxAge(SeckillUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
        return Result.success(true);
    }
}
