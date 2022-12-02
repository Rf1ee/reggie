package com.f1ee.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.f1ee.reggie.common.R;
import com.f1ee.reggie.dto.DishDto;
import com.f1ee.reggie.dto.SetmealDto;
import com.f1ee.reggie.entity.Category;
import com.f1ee.reggie.entity.Dish;
import com.f1ee.reggie.entity.Setmeal;
import com.f1ee.reggie.entity.SetmealDish;
import com.f1ee.reggie.service.CategoryService;
import com.f1ee.reggie.service.DishService;
import com.f1ee.reggie.service.SetmealDishService;
import com.f1ee.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 套餐管理
 */
@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SetmealDishService setmealDishService;

    @Autowired
    private DishService dishService;
    /**
     * 新增套餐
     * @param setmealDto
     * @return
     */
    @PostMapping
    @CacheEvict(value = "setmealCache", allEntries = true)
    public R<String> save(@RequestBody SetmealDto setmealDto) {
        log.info("套餐信息：{}",setmealDto);

        setmealService.saveWithDish(setmealDto);

        return R.success("新增套餐成功");
    }

    /**
     * 套餐分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        //分页构造器对象
        Page<Setmeal> pageInfo = new Page<>(page, pageSize);
        Page<SetmealDto> dtoPage = new Page<>();

        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据name进行like模糊查询
        queryWrapper.like(name != null,Setmeal::getName,name);
        //添加排序条件,根据更新时间排序
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        setmealService.page(pageInfo, queryWrapper);
        
        //对象拷贝
        BeanUtils.copyProperties(pageInfo, dtoPage,"records");
        List<Setmeal> records = pageInfo.getRecords();
        
        List<SetmealDto> list = records.stream().map((item) -> {
            SetmealDto setmealDto = new SetmealDto();
            //对象拷贝
            BeanUtils.copyProperties(item,setmealDto);
            //分类id
            Long categoryId = item.getCategoryId();
            //根据分类id查询分类对象
            Category category = categoryService.getById(categoryId);
            if(category != null) {
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
            }
            return setmealDto;
        }).collect(Collectors.toList());

        dtoPage.setRecords(list);
        return R.success(dtoPage);
    }

    /**
     * 删除菜品
     * @param ids
     * @return
     */
    @DeleteMapping
    @CacheEvict(value = "setmealCache", allEntries = true)
    public R<String> delete(Long[] ids) {
        log.info(ids.toString());
         setmealService.removeWithDish(ids);
        return R.success("删除套餐成功");
    }

    /**
     * 修改套餐状态，菜品停售套餐也停售
     * @param status
     * @param ids
     * @return
     */
    @PostMapping("/status/{status}")
    public R<String> status1(@PathVariable Integer status, Long[] ids) {
        log.info(status.toString());
        log.info(ids.toString());

        LambdaUpdateWrapper<Setmeal> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.in(Setmeal::getId,ids).set(Setmeal::getStatus,status);
        setmealService.update(updateWrapper);
        return R.success("修改状态成功");
    }


    /**
     * 根据id查询套餐信息，回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<SetmealDto> getById(@PathVariable Long id) {
        log.info(id.toString());
        SetmealDto setmealDto = setmealService.getByIdWithDish(id);
       return R.success(setmealDto);
    }


    /**
     * 根据分类id查询套餐信息，回显
     *
     * @param
     * @return
     */
    @GetMapping("/list")
    @Cacheable(value = "setmealCache", key = "#categoryId + '_' + #status")
    public R<List<Setmeal>> getSetmealById(Long categoryId, Integer status) {
        log.info(categoryId.toString());
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Setmeal::getCategoryId,categoryId);
        queryWrapper.eq(Setmeal::getStatus,status);
        List<Setmeal> list = setmealService.list(queryWrapper);
        return R.success(list);
    }

    /**
     * 修改套餐
     * @param setmealDto
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody SetmealDto setmealDto) {
        setmealService.updateWithDish(setmealDto);
        return R.success("修改套餐成功");
    }

    /**
     * 根据id查询套餐菜品
     * @param id
     * @return
     */
    @GetMapping("/dish/{id}")
    public R<List<Dish>> getDishById(@PathVariable Long id) {
        log.info(id.toString());

        LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId,id);
        List<SetmealDish> list = setmealDishService.list(queryWrapper);
        List<Dish> collect = list.stream().map((item) -> {
            Long dishId = item.getDishId();
            Dish dish = dishService.getById(dishId);
            return dish;
        }).collect(Collectors.toList());
        return R.success(collect);
    }


}
