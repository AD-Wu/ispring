package com.x.product.api;

import com.x.data.dto.ProductCommentDto;
import com.x.data.entity.Product;
import com.x.data.entity.ProductComment;
import com.x.data.entity.User;
import com.x.product.dao.IProductCommentDao;
import com.x.product.dao.IProductDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.x.product.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 商品接口
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
    private RestTemplate restTemplate;
    
    @Autowired
    private IUserService userService;

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
     * @return 商品
     */
    @GetMapping("/{id}")
    public Product detail(@PathVariable Long id) {
        Product product = productDao.findById(id).get();
        return product;
    }

    /**
     * 获取商品评论信息
     *
     * @param id 商品ID
     * @return
     */
    @GetMapping("/{id}/comments")
    public List<ProductCommentDto> comments(@PathVariable Long id) throws Exception{

        List<ProductComment> pcs = productCommentDao.findByProductIdOrderByCreated(id);
        if (pcs != null && !pcs.isEmpty()) {
            List<ProductCommentDto> pcds = new ArrayList<>();
            for (ProductComment pc : pcs) {
                ProductCommentDto pcd = new ProductCommentDto();
                pcd.setId(pc.getId());
                pcd.setContent(pc.getContent());
                pcd.setCreated(pc.getCreated());
                pcd.setProduct(getProduct(pc.getProductId()));
                pcd.setAuthor(getUser(pc.getAuthorId()));
                pcds.add(pcd);
            }
            return pcds;
        }
        return Collections.emptyList();
    }

    private Product getProduct(Long productId) {
        Product product = productDao.findById(productId).get();
        return product;
    }
    
    private User getUser(Long userId){
        User user = userService.detail(userId);
        return user;
    }

    private User getAuthor(Long authorId) {
        User user = restTemplate.getForEntity("http://user-service/users/{id}", User.class, authorId).getBody();
        log.info("获取用户:{}", user);
        return user;
    }

}
