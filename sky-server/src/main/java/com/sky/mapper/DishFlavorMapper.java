package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName dishMapper
 * @author: c9noo
 * @create: 2023-09-18 16:15
 * @Version 1.0
 **/

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 批量删除口味数据
     * @param ids
     */
    void deleteByDishIds(List<Long> ids);
}
