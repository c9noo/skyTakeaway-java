package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import lombok.ToString;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName ShoppingCartMapper
 * @author: c9noo
 * @create: 2023-09-23 20:54
 * @Version 1.0
 **/
@Mapper
public interface ShoppingCartMapper {

    /**
     * 动态查询语句，查询shoppingCart
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 修改数量
     * @param cart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart cart);

    /**
     * 插入数据
     * @param shoppingCart
     */
    @Insert("insert into shopping_cart (name, image, user_id, dish_id, setmeal_id, dish_flavor, amount, create_time) VALUE " +
            "(#{name},#{image},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{amount},#{createTime})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 清空购物车
     * @param userId
     */
    @Delete("delete from shopping_cart where user_id = #{userId}")
    void deleteById(Long userId);

    /**
     * 删除购物车中的一个商品
     * @param shoppingCart
     */
    void deleteOneById(ShoppingCart shoppingCart);
}
