package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @program: sky-take-out
 * @ClassName UserService
 * @author: c9noo
 * @create: 2023-09-21 20:33
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 微信用户登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);
}
