package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜品及套餐分类(Category)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-05 13:25:01
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}

