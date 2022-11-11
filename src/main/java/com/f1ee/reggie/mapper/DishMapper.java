package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜品管理(Dish)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-05 14:36:23
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}

