package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName CategoryMapper
 * @author: c9noo
 * @create: 2023-09-18 12:20
 * @Version 1.0
 **/
@Mapper
public interface CategoryMapper {


    @Insert("insert into category (type,name,sort,status,create_time,update_time,create_user,update_user)"
    +"values "+
            "(#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})"
    )
    void insert(Category category);

    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);


    List<Category> list(Integer type);

    void update(Category category);

    @Delete("delete from category where id = #{categoryId}")
    void delete(Long categoryId);
}