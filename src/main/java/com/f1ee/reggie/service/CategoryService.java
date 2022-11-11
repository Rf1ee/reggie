package com.f1ee.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.f1ee.reggie.entity.Category;

/**
 * 菜品及套餐分类(Category)表服务接口
 *
 * @author f1ee
 * @since 2022-11-05 13:25:22
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}

