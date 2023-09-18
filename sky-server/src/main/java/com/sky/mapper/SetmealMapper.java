package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: sky-take-out
 * @ClassName SetmealMapper
 * @author: c9noo
 * @create: 2023-09-18 16:16
 * @Version 1.0
 **/

@Mapper
public interface SetmealMapper {

    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
}
