package com.x.web.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品评价
 *
 * @author AD
 * @date 2021/10/4 17:34
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
     * 所示商品ID
     */
    private Long productId;
    
    /**
     * 评论作者ID
     */
    private Long authorId;
    
    /**
     * 评论内容
     */
    private String content;
    
    /**
     * 评论创建时间
     */
    private LocalDateTime created;
    
}
