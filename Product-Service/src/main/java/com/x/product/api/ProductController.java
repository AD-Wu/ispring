package com.x.product.api;

import com.netflix.discovery.converters.Auto;
import com.x.data.entity.Product;
import com.x.data.entity.ProductComment;
import com.x.product.dao.IProductCommentDao;
import com.x.product.dao.IProductDao;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * TODO
 *
 * @author AD
 * @date 2021/10/10 23:17
 */
@Log4j2
@RestController
@RequestMapping("products")
public class ProductController {
    
    @Autowired
    private IProductDao productDao;
    
    @Autowired
    private IProductCommentDao productCommentDao;
    
    @Autowired
    private RestTemplate http;
    
    /**
     * 获取商品列表
     *
     * @return 所有商品
     */
    @GetMapping
    public List<Product> list() {
        List<Product> products = productDao.findAll();
        return products;
    }
    
    /**
     * 获取商品详情
     *
     * @param id 商品ID
     *
     * @return 商品
     */
    @GetMapping("/{id}")
    public Product detail(@PathVariable Long id) {
        Product product = productDao.findById(id).get();
        return product;
    }
    
    @GetMapping("/{id}/comments")
    public List<ProductComment> comments(@PathVariable Long id) {
        ProductComment pc = new ProductComment();
        pc.setProductId(id);
        Example<ProductComment> where = Example.of(pc);
        Sort.TypedSort<LocalDateTime> sort = Sort.sort(ProductComment.class).by(ProductComment::getCreated);
        List<ProductComment> pcs = productCommentDao.findAll(where, sort);
        if(pcs!=null&&!pcs.isEmpty()){
        
        }
        return null;
    }
    
}
