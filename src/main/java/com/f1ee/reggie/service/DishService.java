package com.f1ee.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.f1ee.reggie.dto.DishDto;
import com.f1ee.reggie.entity.Dish;

/**
 * 菜品管理(Dish)表服务接口
 *
 * @author f1ee
 * @since 2022-11-05 14:36:24
 */
public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish，dish_flavor
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品信息，同时更新对应的口味信息
    void updateWithFlavor(DishDto dishDto);

    //菜品停售时，包含该菜品的套餐也应停售
    void updateWithSetmeal(Integer status, Long[] ids);
}

