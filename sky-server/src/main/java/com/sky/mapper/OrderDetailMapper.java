package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName OrderDetailMapper
 * @author: c9noo
 * @create: 2023-09-24 12:55
 * @Version 1.0
 **/
@Mapper
public interface OrderDetailMapper {

    /**
     * 批量插入订单明显
     * @param orderDetails
     */
    void insertBatch(List<OrderDetail> orderDetails);

    @Select("select * from order_detail where order_id = #{id}")
    List<OrderDetail> getByOrderId(Long id);
}
