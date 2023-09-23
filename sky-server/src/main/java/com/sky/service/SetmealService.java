package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName SetmealService
 * @author: c9noo
 * @create: 2023-09-20 08:34
 * @Version 1.0
 **/
public interface SetmealService {

    /**
     * 新增套餐
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);

    /**
     * 分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 根据id查询套餐信息
     * @param id
     * @return
     */
    SetmealVO getByIdSetmeal(Long id);

    /**
     * 修改菜品信息
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);

    /**
     * 修改套餐状态
     */
    void startOnStop(Integer status,Long id);

    /**
     * 根据套餐id批量删除
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据分类id查询套餐
     * @param categoryId
     * @return
     */
    List<Setmeal> list(Long categoryId);

    /**
     * 根据套餐id查询菜品
     * @param setmealId
     * @return
     */
    List<DishItemVO> getDishItemById(Long setmealId);
}
