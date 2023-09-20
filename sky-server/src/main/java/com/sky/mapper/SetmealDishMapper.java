package com.sky.mapper;

import com.sky.entity.Dish;
import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName SetmealDishMapper
 * @author: c9noo
 * @create: 2023-09-19 15:46
 * @Version 1.0
 **/
@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 批量插入菜品和套餐的关系
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);


    @Select("select * from setmeal_dish where setmeal_id = #{id}")
    List<SetmealDish> getSetmealDishById(Long id);

    @Delete("delete from setmeal_dish where setmeal_id = #{id}")
    void deleteBySetmealId(Long setmealId);

    /**
     * 根据id批量删除对应的套餐菜品
     */
    void deleteBySetmealIds(List<Long> ids);

}
