package com.x.web.service.impl;

import com.x.web.dao.IUserDao;
import com.x.web.entity.User;
import com.x.web.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.TypedSort;
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
