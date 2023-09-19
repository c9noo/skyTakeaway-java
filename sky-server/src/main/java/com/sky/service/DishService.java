package com.sky.service;

import com.sky.dto.DishDTO;

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
}
