package com.roomio.miaosha.service;

import com.roomio.miaosha.dao.UserDao;
import com.roomio.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao dao;
    public User getuserById(int id){
      return  dao.getuserById(id);
    }
    @Transactional
    public boolean insert() {
        User u1= new User(3,"WWW",18);
        dao.insert(u1);
        User u2= new User(1,"sda",28);
        dao.insert(u2);
        return true;
    }
}
