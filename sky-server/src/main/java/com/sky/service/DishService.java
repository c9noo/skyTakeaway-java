package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName DishService
 * @author: c9noo
 * @create: 2023-09-19 13:57
 * @Version 1.0
 **/
public interface DishService {
    /**
     * 新增菜品和口味
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品批量删除
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查询对应的菜品和口味
     * @param id
     * @return
     */
    DishVO getByIdWithFlavor(Long id);


    /**
     * 修改菜品
     * @param dishDTO
     * @return
     */
    void updateWithFlavor(DishDTO dishDTO);

    /**
     * 起售停售菜品
     * @param status
     * @param id
     * @return
     */
    void startOnStop(Integer status, Long id);


    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    List<Dish> getCategoryDishWithId(Long categoryId);
}
