package com.emp.empsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.emp.empsystem.entity.SysProduct;
import com.emp.empsystem.entity.SysUser;
import com.emp.empsystem.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Liu
 * @create 2019/4/23 10:55
 */
@Controller
public class ProductController {
    //购买商品
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping("/order-add.html")
    public String order_add() {
        return "views/products/order-add";
    }
    //商品页面
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping("/order-list.html")
    public String order_list() {
        return "views/products/order-list";
    }

    @Resource
    private ProductService productService;

    //分页获取商品
    @ResponseBody
    @RequestMapping(value = "/findProduct", produces = "text/html;charset=UTF-8")
    public String findProduct(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
        JSONObject json = new JSONObject();
        int PageSize = 5;
        List<SysProduct> productList = productService.findProductByPage((currentPage - 1) * PageSize, PageSize);
        Integer count = productService.count();
        Integer countPage = count % PageSize == 0 ? count / PageSize : count / PageSize + 1;
        json.put("count", count);
        json.put("currentPage", currentPage);
        json.put("countPage", countPage);
        json.put("productList", productList);
        return json.toJSONString(json);
    }
    //获取商品总数
    @ResponseBody
    @RequestMapping("/getProductCount")
    public int getUserCount() {
        int count = productService.count();
        if (count != 0) {
            return count;
        }
        return 0;
    }
}
