package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.CategoryMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: sky-take-out
 * @ClassName CategoryServiceImpl
 * @author: c9noo
 * @create: 2023-09-18 11:29
 * @Version 1.0
 **/
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private SetmealMapper setmealMapper;


    /**
     * 新增分类
     * @param categoryDTO
     */
    @Override
    public void save(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                .status(0)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .createUser(BaseContext.getCurrentId())
                .updateUser(BaseContext.getCurrentId())
                .status(StatusConstant.DISABLE)
                .build();
        BeanUtils.copyProperties(categoryDTO,category);

        categoryMapper.insert(category);
    }

    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {

        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        Page<Category> categories = categoryMapper.pageQuery(categoryPageQueryDTO);

        return new PageResult(categories.getTotal(),categories.getResult());
    }

    /**
     * 通过类别进行分类
     * @param type
     * @return
     */
    @Override
    public List<Category> list(Integer type) {

        return categoryMapper.list(type);
    }

    /**
     * 启用禁用分类
     * @param status
     * @param id
     */
    @Override
    public void statusOnStop(Integer status, Long id) {
        Category category = Category.builder()
                .status(status)
                .id(id)
                .updateTime(LocalDateTime.now())
                .updateUser(BaseContext.getCurrentId())
                .build();
        categoryMapper.update(category);
    }

    /**
     * 更新分类信息
     * @param categoryDTO
     */
    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                .updateUser(BaseContext.getCurrentId())
                .updateTime(LocalDateTime.now())
                .build();
        BeanUtils.copyProperties(categoryDTO,category);
        categoryMapper.update(category);
    }

    /**
     * 删除分类
     * @param id
     */
    @Override
    public void delete(Long id) {
        //1. 判断分类中是否有菜品
        if( 0  != dishMapper.countByCategoryId(id)){
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_DISH);
        }
        if (0 != setmealMapper.countByCategoryId(id)){
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_SETMEAL);
        }
        categoryMapper.delete(id);
    }
}
