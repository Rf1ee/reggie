package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

/**
 * 套餐(Setmeal)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-05 14:40:23
 */
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {

}

