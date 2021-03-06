package com.roomio.miaosha.dao;

import com.roomio.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from users where id=#{id}")
    public User getuserById(@Param("id") String id);

    @Insert("insert users(id,name,age) values(#{id},#{name},#{age})")
    boolean insert(User user);

    @Select("select * from users" )
    List<User> getAlluerInTable();
}
