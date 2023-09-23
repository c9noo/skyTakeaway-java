package com.sky.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sky.constant.MessageConstant;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.exception.LoginFailedException;
import com.sky.mapper.UserMapper;
import com.sky.properties.WeChatProperties;
import com.sky.service.UserService;
import com.sky.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: sky-take-out
 * @ClassName UserServiceImpl
 * @author: c9noo
 * @create: 2023-09-21 20:41
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private WeChatProperties weChatProperties;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String openId = getOpenId(userLoginDTO.getCode());
        //判断openId是否存在 如果不存在代表登录失败
        if (openId == null){
            throw new LoginFailedException(MessageConstant.LOGIN_FAILED);
        }

        //判断这个openId是不是新登录的
        User user = userMapper.getByOpenId(openId);

        //如果是的话 就进行注册
        if (user == null){
            user = User.builder()
                    .openid(openId)
                    .createTime(LocalDateTime.now())
                    .build();
            userMapper.insert(user);
        }

        return user;
    }

    /**
     * 调用微信接口，获取用户的openId
     * @param code
     * @return
     */
    private String getOpenId(String code){
        //调用微信接口 获取当前用户的openId
        Map<String, String> map = new HashMap<>();
        map.put("appid",weChatProperties.getAppid());
        map.put("secret",weChatProperties.getSecret());
        map.put("js_code",code);
        map.put("grant_type","authorization_code");
        String s = HttpClientUtil.doGet("https://api.weixin.qq.com/sns/jscode2session", map);

        JSONObject jsonObject = JSON.parseObject(s);
        String openId = jsonObject.getString("openid");

        return openId;
    }
}
