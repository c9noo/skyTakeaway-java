package com.sky.controller.user;

import com.sky.constant.StatusConstant;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName DishController
 * @author: c9noo
 * @create: 2023-09-23 09:57
 * @Version 1.0
 **/
@RestController("userDishController")
@RequestMapping("/user/dish")
@Slf4j
@Api(tags = "菜品浏览接口")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<DishVO>> list(Long categoryId){
        log.info("当前要查询的分类id是{}",categoryId);
        Dish dish = Dish.builder()
                .status(StatusConstant.ENABLE)
                .categoryId(categoryId)
                .build();
        List<DishVO> list =  dishService.listWithFlavor(dish);

        return Result.success(list);
    }
}
