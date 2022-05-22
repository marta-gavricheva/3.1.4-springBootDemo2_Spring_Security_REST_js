package com.example.springBootdemo2.service;

import com.example.springBootdemo2.dao.UserDao;
import com.example.springBootdemo2.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;


@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserId(long id) {
        return userDao.getUserId(id);
    }

    @Override
    @Transactional
    public User addUser(User user) {
        userDao.addUser(user);
        return user;
    }

    @Override
   public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public User removeUser(long id) {
        return userDao.removeUser(id);
    }

    @Override
    public User getByName(String username) {
        return userDao.getByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getByName(s);
        return user;
    }




}