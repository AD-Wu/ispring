package com.x.data.dto;

import com.x.data.entity.Product;
import com.x.data.entity.User;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * TODO
 *
 * @author chunquanw
 * @date 2021/10/12 11:15
 */
@Data
public class ProductCommentDto {

    private Long id;

    /**
     * 所属商品
     */
    private Product product;

    /**
     * 作者ID
     */
    private User author;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime created;
}
