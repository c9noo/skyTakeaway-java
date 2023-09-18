package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName CategoryService
 * @author: c9noo
 * @create: 2023-09-18 11:29
 * @Version 1.0
 **/

public interface CategoryService {

    /**
     * 新增分类
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> list(Integer type);

    /**
     * 修改分类状态
     * @param status
     * @param id
     */
    void statusOnStop(Integer status, Long id);

    /**
     * 修改分类信息
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 删除分类
     * @param id
     */
    void delete(Long id);

}
