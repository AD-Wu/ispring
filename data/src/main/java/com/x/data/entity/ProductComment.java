package com.x.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品
 *
 * @author AD
 * @date 2021/10/10 23:27
 */
@Data
@Entity
public class ProductComment implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    
    /**
     * 所属商品
     */
    private Long productId;
    
    /**
     * 作者ID
     */
    private Long authorId;
    
    /**
     * 评论内容
     */
    private String content;
    
    /**
     * 创建时间
     */
    private LocalDateTime created;
    
}
