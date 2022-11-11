package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * 地址管理(AddressBook)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-10 16:08:15
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {

}

