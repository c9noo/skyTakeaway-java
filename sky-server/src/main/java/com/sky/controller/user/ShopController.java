package com.sky.controller.user;

import com.sky.constant.ShopConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @program: sky-take-out
 * @ClassName ShopController
 * @author: c9noo
 * @create: 2023-09-20 17:19
 * @Version 1.0
 **/
@RestController("userShopController")
@RequestMapping("/user/shop")
@Slf4j
@Api(tags = "店铺状态相关接口")
public class ShopController {
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 获取店铺状态
     * @return
     */
    @GetMapping("/status")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(ShopConstant.ShopStatus);
        log.info("当前的状态为{}",status);
        return Result.success(status);
    }
}
