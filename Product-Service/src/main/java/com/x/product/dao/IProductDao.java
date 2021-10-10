package com.x.product.dao;

import com.x.data.entity.Product;
import com.x.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 商品DAO
 *
 * @author AD
 * @date 2021/10/4 19:05
 */
public interface IProductDao extends JpaRepository<Product,Long> {
}
