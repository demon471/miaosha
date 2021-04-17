package com.roomio.miaosha.service;

import com.roomio.miaosha.dao.UserDao;
import com.roomio.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao dao;
    public User getuserById(int id){
      return  dao.getuserById(id);
    }
}
