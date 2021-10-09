package com.x.web.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 商品
 *
 * @author AD
 * @date 2021/10/4 17:30
 */
@Data
@Entity
public class Product implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 商品数据库主键
     */
    @Id
    @GeneratedValue
    private Long id;
    
    /**
     * 商品名称
     */
    private String name;
    
    /**
     * 商品封面图片
     */
    private String coverImage;
    
    /**
     * 商品价格
     */
    private int price;
    
}
