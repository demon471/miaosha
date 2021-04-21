package com.roomio.miaosha.dao;

import com.roomio.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author biqiang
 * @version 2021/4/21
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
@Mapper
public interface MiaoshaDao {
    @Select("select * from miaosha_user where id=#{id}")
        public MiaoshaUser getMiaoshaUserById(@Param("id") Long id);

 }
