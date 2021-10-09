package com.x.web.dao;

import com.x.web.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 *
 * @author AD
 * @date 2021/10/4 19:07
 */
public interface IProductDao extends JpaRepository<Product,Long> {
}
