package com.f1ee.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.f1ee.reggie.dto.SetmealDto;
import com.f1ee.reggie.entity.Setmeal;

/**
 * 套餐(Setmeal)表服务接口
 *
 * @author f1ee
 * @since 2022-11-05 14:40:23
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联关系
     * @param ids
     */
    void removeWithDish(Long[] ids);

    //根据id查询套餐信息
    SetmealDto getByIdWithDish(Long id);

    //更新套餐信息，同时更新套餐中的菜品
    void updateWithDish(SetmealDto setmealDto);
}

