package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜品口味关系表(DishFlavor)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-06 13:38:50
 */
@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {

}

