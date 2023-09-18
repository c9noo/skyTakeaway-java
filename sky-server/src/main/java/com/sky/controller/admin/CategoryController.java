package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName CategoryController
 * @author: c9noo
 * @create: 2023-09-18 11:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增的分类是{}",categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分页查询的信息是{}",categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        log.info("需要查询的类型是{}",type);
        List list = categoryService.list(type);
        return Result.success(list);
    }

    /**
     * 修改分类状态
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("修改状态")
    public Result startOnStop(@PathVariable Integer status,Long id){
        log.info("需要修改状态的id是{}",id);
        categoryService.statusOnStop(status,id);
        return Result.success();
    }

    /**
     * 修改分类信息
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        log.info("需要修改分类的信息{}",categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 修改分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result delete(Long id){
        log.info("要删除的分类是{}",id);
        categoryService.delete(id);
        return Result.success();
    }
}
