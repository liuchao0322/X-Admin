package com.emp.empsystem.entity;

/**
 * @Author Liu
 * @create 2019/4/23 10:06
 */
public class SysProduct {
    private int id;
    //商品名称
    private String products_name;
    //商品价格
    private Double products_prices;
    //商品描述
    private String Products_desc;
    //商品类别
    private SysPtype sysPtype;

    public SysProduct() {

    }

    @Override
    public String toString() {
        return "SysProduct{" +
                "id=" + id +
                ", products_name='" + products_name + '\'' +
                ", products_prices=" + products_prices +
                ", Products_desc='" + Products_desc + '\'' +
                ", sysPtype=" + sysPtype +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducts_name() {
        return products_name;
    }

    public void setProducts_name(String products_name) {
        this.products_name = products_name;
    }

    public Double getProducts_prices() {
        return products_prices;
    }

    public void setProducts_prices(Double products_prices) {
        this.products_prices = products_prices;
    }

    public String getProducts_desc() {
        return Products_desc;
    }

    public void setProducts_desc(String products_desc) {
        Products_desc = products_desc;
    }

    public SysPtype getSysPtype() {
        return sysPtype;
    }

    public void setSysPtype(SysPtype sysPtype) {
        this.sysPtype = sysPtype;
    }

    public SysProduct(int id, String products_name, Double products_prices, String products_desc, SysPtype sysPtype) {
        this.id = id;
        this.products_name = products_name;
        this.products_prices = products_prices;
        Products_desc = products_desc;
        this.sysPtype = sysPtype;
    }
}
