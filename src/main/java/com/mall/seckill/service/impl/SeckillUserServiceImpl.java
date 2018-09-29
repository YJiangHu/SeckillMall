package com.mall.seckill.service.impl;

import com.mall.seckill.cache.RedisService;
import com.mall.seckill.cache.SeckillUserKey;
import com.mall.seckill.dao.SeckillUserDao;
import com.mall.seckill.domain.SeckillUser;
import com.mall.seckill.enums.CodeMsg;
import com.mall.seckill.exception.GlobalException;
import com.mall.seckill.service.SeckillUserService;
import com.mall.seckill.util.MD5Util;
import com.mall.seckill.vo.LoginUserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillUserServiceImpl implements SeckillUserService {


    @Autowired
    private SeckillUserDao seckillUserDao;

    @Autowired
    private RedisService redisService;

    @Override
    public SeckillUser getUserById(Long id) {
        return seckillUserDao.getSeckillUserById(id);
    }

    @Override
    public SeckillUser login(LoginUserVo loginUserVo) {
        if(loginUserVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginUserVo.getMobile();
        String password = loginUserVo.getPassword();
        SeckillUser seckillUser = getUserById(Long.parseLong(mobile));
        if(seckillUser == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPassWord = seckillUser.getPassword();
        System.out.println("db: " + dbPassWord);
        String passwordToDbPassword = MD5Util.md5(password);
        System.out.println("form: " + passwordToDbPassword);
        if(!passwordToDbPassword.equals(dbPassWord)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        return seckillUser;
    }

    @Override
    public Object getByToken(String token) {
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        SeckillUser user = redisService.get(SeckillUserKey.token, token, SeckillUser.class);
        return user;
    }
}
