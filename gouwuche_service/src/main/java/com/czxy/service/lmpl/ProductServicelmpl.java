package com.czxy.service.lmpl;

import com.czxy.dao.ProductMapper;
import com.czxy.domain.Product;
import com.czxy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 刘昌燊
 * @version v 1.0
 * @date 2019/7/22
 */
@Service
@Transactional
public class ProductServicelmpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }




}
