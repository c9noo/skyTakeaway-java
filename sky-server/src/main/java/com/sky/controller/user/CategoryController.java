package com.sky.controller.user;

import com.sky.entity.Category;
import com.sky.result.Result;
import com.sky.service.CategoryService;
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
 * @ClassName CategoryController
 * @author: c9noo
 * @create: 2023-09-23 09:39
 * @Version 1.0
 **/
@RestController("userCategoryController")
@RequestMapping("/user/category")
@Slf4j
@Api(tags = "C端-分类接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据条件查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("条件查询")
    public Result<List<Category>> list(Integer type){
        log.info("当前的条件是{}",type);
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }

}
