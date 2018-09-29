package com.mall.seckill.service;

import com.mall.seckill.domain.SeckillUser;
import com.mall.seckill.vo.LoginUserVo;

public interface SeckillUserService {
    public static String COOKIE_NAME = "loginToken";

    SeckillUser getUserById(Long id);
    SeckillUser login(LoginUserVo loginUserVo);

    Object getByToken(String token);
}
