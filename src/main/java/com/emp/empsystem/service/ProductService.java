package com.emp.empsystem.service;

import com.emp.empsystem.entity.SysProduct;

import java.util.List;

/**
 * @Author Liu
 * @create 2019/4/23 10:53
 */
public interface ProductService {
    //获取商品分页信息
    List<SysProduct> findProductByPage(int currentPage, int PageSize);
    //获取商品总数
    int count();
}
