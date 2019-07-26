package com.czxy.service;

import com.czxy.domain.Product;

import java.util.List;

/**
 * @author 刘昌燊
 * @version v 1.0
 * @date 2019/7/22
 */
public interface ProductService {

    public List<Product>findAll();


    public Product findById(Integer id);



}
