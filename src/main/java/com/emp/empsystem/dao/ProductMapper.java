package com.emp.empsystem.dao;

import com.emp.empsystem.entity.SysProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Liu
 * @create 2019/4/23 10:14
 */
@Mapper
public interface ProductMapper {
    //获取商品分页信息
    List<SysProduct> findProductByPage(int currentPage, int PageSize);
    //获取商品总数
    @Select("select count(1) from sys_product")
    int count();
}
