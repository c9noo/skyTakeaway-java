package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: sky-take-out
 * @ClassName dishMapper
 * @author: c9noo
 * @create: 2023-09-18 16:15
 * @Version 1.0
 **/

@Mapper
public interface DishMapper {

    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
}
