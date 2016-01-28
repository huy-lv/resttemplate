package com.study.dao;

import com.study.dao.model.Product;

import java.util.List;

/**
 * Created by kimtung on 1/27/16.
 */
public interface ProductDao {

    void insert(Product product);

    List<Product> list();

    public List<Product> list(int pageNum, int pageSize);

    Long count();

    void update(Product product);

    void delete(Product product);

    public Product getById(long id);
}
