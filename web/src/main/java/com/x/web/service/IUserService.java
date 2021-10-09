package com.x.web.service;

import com.x.web.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 用户接口
 *
 * @author AD
 * @date 2021/10/4 19:04
 */
public interface IUserService {
    
    /**
     * 获取用户分页数据
     *
     * @param pageable 分页参数
     *
     * @return 分页数据
     */
    Page<User> getPage(Pageable pageable);
    
    /**
     * 加载指定用户信息
     *
     * @param id 用户主键
     *
     * @return
     */
    User load(Long id);
    
    /**
     * 保存/更新用户
     *
     * @param user
     *
     * @return
     */
    User save(User user);
    
    /**
     * 删除用户
     *
     * @param id
     */
    void delete(Long id);
    
}
