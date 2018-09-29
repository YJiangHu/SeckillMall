package com.mall.seckill.dao;

import com.mall.seckill.domain.SeckillUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component(value = "seckillUserDao")
public interface SeckillUserDao {
    //1. 根据用户ID查找用户
    @Select("SELECT * FROM seckill_user WHERE id = #{id}")
    SeckillUser getSeckillUserById(Long id);

    //2. 增加用户
    @Insert("INSERT INTO seckill_user VALUES(#{id}, #{nickname}, #{password}, #{head}," +
            " #{registerDate}, #{lastLoginDate}")
    int insertSeckillUser(SeckillUser seckillUser);

    //3. 修改密码
    @Update("UPDATE seckill_user SET password = #{password} WHERE id = #{id}")
    int updateSeckillUser(SeckillUser seckillUser);
}
