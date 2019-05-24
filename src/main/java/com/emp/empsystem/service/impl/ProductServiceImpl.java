package com.emp.empsystem.service.impl;

import com.emp.empsystem.dao.ProductMapper;
import com.emp.empsystem.entity.SysProduct;
import com.emp.empsystem.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Liu
 * @create 2019/4/23 10:54
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Override
    public List<SysProduct> findProductByPage(int currentPage, int PageSize) {
        return productMapper.findProductByPage(currentPage, PageSize);
    }

    @Override
    public int count() {
        return productMapper.count();
    }
}
