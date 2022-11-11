package com.f1ee.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.f1ee.reggie.mapper.AddressBookMapper;
import com.f1ee.reggie.entity.AddressBook;
import com.f1ee.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * 地址管理(AddressBook)表服务实现类
 *
 * @author f1ee
 * @since 2022-11-10 16:08:19
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}

