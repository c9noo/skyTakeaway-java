package com.sky.mapper;

import com.sky.entity.DishFlavor;
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


    void insertBatch(List<DishFlavor> flavors);
}
