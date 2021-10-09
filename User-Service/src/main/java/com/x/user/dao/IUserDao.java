package com.x.user.dao;

import com.x.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户DAO
 *
 * @author AD
 * @date 2021/10/4 19:05
 */
public interface IUserDao extends JpaRepository<User,Long> {
}
