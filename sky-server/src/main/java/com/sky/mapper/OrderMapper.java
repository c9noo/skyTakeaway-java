package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: sky-take-out
 * @ClassName OrderMapper
 * @author: c9noo
 * @create: 2023-09-24 12:54
 * @Version 1.0
 **/
@Mapper
public interface OrderMapper {
    /**
     * 插入订单
     * @param orders
     */
    void insert(Orders orders);
}
