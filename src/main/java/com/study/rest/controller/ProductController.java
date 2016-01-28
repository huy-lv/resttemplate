package com.study.rest.controller;

import com.study.dao.ProductDao;
import com.study.dao.model.Product;
import com.study.rest.message.AllProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kimtung on 1/27/16.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping()
    public AllProductResponse list(
            @RequestParam(name = "pageSize", defaultValue = "25") int pageSize,
            @RequestParam(name = "pageNum", defaultValue = "1") int pageNum ){

        List<Product> products = productDao.list(pageNum, pageSize);
        AllProductResponse response = new AllProductResponse();
        response.setPage(pageNum);
        for (Product product : products) {
            AllProductResponse.ProductItem item = new AllProductResponse.ProductItem();
            item.setId(product.getId())
                    .setName(product.getName())
                    .setType(product.getType().getName())
                    .setDetail(product.getDetail());
            response.getItems().add(item);
        }
        return response;
    }

    @RequestMapping("/count")
    public Long count() {
        return productDao.count();
    }

    @RequestMapping("*")
    public String fallback() {
        return "I don't know what you're asking :3";
    }

    @RequestMapping("/error")
    public String error() {
        return "Bug again? wtf!!!";
    }


    @RequestMapping("/detail")
    public AllProductResponse.ProductItem viewDetail(
        @RequestParam(name = "id", defaultValue = "0") int id){

        Product product  = productDao.getById(id);
        return new AllProductResponse.ProductItem(product.getId(),product.getName(),product.getDetail(),product.getType().getName());
    }


}
