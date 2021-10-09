package com.x.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户
 * @author AD
 * @date 2021/10/4 17:22
 */
@Data
@Entity
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 用户数据主键
     */
    @Id
    @GeneratedValue
    private Long id;
    
    /**
     * 用户昵称
     */
    private String nickname;
    
    /**
     * 用户头像
     */
    private String avatar;
    
    
    
}
