package com.eauction.service;

import java.util.List;

import com.eauction.dao.UserDAO;
import com.eauction.model.User;

public class UserService {
    private static UserDAO userDao;
    
    public UserService() {
        userDao = new UserDAO();
    }
 
    public void persist(User entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.persist(entity);
        userDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(User entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionwithTransaction();
    }
 
    public User findById(String id) {
        userDao.openCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }
 
    public List<User> findByEmail(String email) {
        userDao.openCurrentSession();
        List<User> users = userDao.findUsersByEmail(email);
        userDao.closeCurrentSession();
        return users;
    }
    
    public void delete(String id) {
        userDao.openCurrentSessionwithTransaction();
        User user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionwithTransaction();
    }
 
    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }
 
    public void deleteAll() {
        userDao.openCurrentSessionwithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
    }
 
    public UserDAO userDao() {
        return userDao;
    }
}
