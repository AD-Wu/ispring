package com.x.web.api;

import com.x.web.entity.User;
import com.x.web.service.impl.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * 用户接口
 *
 * @author AD
 * @date 2021/10/4 19:27
 */
@RestController
@RequestMapping("users")
public class UserController {
    
    private static final Logger LOG = LogManager.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    /**
     * 获取指定页所有用户
     * @param pageable 分页参数
     * @return 用户集合
     */
    @GetMapping
    public List<User> findAll(Pageable pageable) throws Exception{
        LOG.info("接收到查询请求:{}", pageable.toString());
        Page<User> page = userService.getPage(pageable);
        if (page != null) {
            List<User> users = page.getContent();
            return users;
        }
        return Collections.emptyList();
    }
    
    /**
     * 获取用户详情
     * @param id 数据库主键
     * @return 用户
     */
    @GetMapping("{id}")
    public User detail(@PathVariable Long id){
        User user = userService.load(id);
        return user;
    }
    
    /**
     * 更新用户信息
     * @param user 新的用户信息
     * @return 更新信息后的用户对象
     */
    @PostMapping("update")
    public User update(@RequestBody User user){
        User newUser = userService.save(user);
        return newUser;
    }
    
    /**
     * 删除用户
     * @param id 数据库主键
     * @return 是否成功：成功(true)，失败(false)
     */
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id){
        userService.delete(id);
        return true;
    }
    
}
