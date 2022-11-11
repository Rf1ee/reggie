package com.f1ee.reggie.dto;

import com.f1ee.reggie.entity.Setmeal;
import com.f1ee.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
