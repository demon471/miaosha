package com.roomio.miaosha.dao;

import com.roomio.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from users where id=#{id}")
    public User getuserById(@Param("id") int id);

    @Insert("insert users(id,name,age) values(#{id},#{name},#{age})")
    boolean insert(User user);
}
