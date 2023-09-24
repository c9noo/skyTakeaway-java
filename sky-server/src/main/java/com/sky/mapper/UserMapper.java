package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: sky-take-out
 * @ClassName UserMapper
 * @author: c9noo
 * @create: 2023-09-21 21:03
 * @Version 1.0
 **/
@Mapper
public interface UserMapper {

    @Select("select * from user where openid = #{openid}")
    User getByOpenId(String openid);

    void insert(User user);

    @Select("select * from user where id = #{userId}" )
    User getById(Long userId);
}
