package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

/**
 * 套餐菜品关系(SetmealDish)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-08 12:51:23
 */

@Mapper
public interface SetmealDishMapper extends BaseMapper<SetmealDish> {

}

