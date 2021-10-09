package com.x.user.service.impl;

import com.x.user.dao.IUserDao;
import com.x.user.entity.User;
import com.x.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author AD
 * @date 2021/10/8 21:14
 */
@Service
public class UserService implements IUserService {
    
    @Autowired
    private IUserDao userDao;
    
    @Override
    public Page<User> getPage(Pageable pageable) {
        return userDao.findAll(pageable);
    }
    
    @Override
    public User load(Long id) {
        return userDao.findById(id).get();
    }
    
    @Override
    public User save(User user) {
        return userDao.save(user);
    }
    
    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
    
}
