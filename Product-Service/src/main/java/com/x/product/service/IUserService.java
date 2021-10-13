package com.x.product.service;

import com.x.data.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * TODO
 *
 * @author AD
 * @date 2021/10/12 23:07
 */
@FeignClient("user-service")
public interface IUserService {
    
    /**
     * 获取指定页所有用户
     *
     * @param pageable 分页参数
     *
     * @return 用户集合
     */
    @GetMapping("/users")
    List<User> findAll(Pageable pageable) throws Exception;
    
    /**
     * 获取用户详情
     *
     * @param id 数据库主键
     *
     * @return 用户
     */
    @GetMapping("/users/{id}")
    User detail(@PathVariable Long id);
    
}
