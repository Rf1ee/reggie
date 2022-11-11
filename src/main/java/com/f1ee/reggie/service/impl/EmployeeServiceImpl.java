package com.f1ee.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.f1ee.reggie.entity.Employee;
import com.f1ee.reggie.mapper.EmployeeMapper;
import com.f1ee.reggie.service.EmployeeService;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
