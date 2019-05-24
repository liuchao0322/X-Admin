package com.emp.empsystem.entity;

/**
 * @Author Liu
 * @create 2019/4/23 10:13
 */
public class SysPtype {
    private int id;
    //商品类别
    private String product_type;

    public SysPtype() {
    }

    @Override
    public String toString() {
        return "SysPtype{" +
                "id=" + id +
                ", product_type='" + product_type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public SysPtype(int id, String product_type) {
        this.id = id;
        this.product_type = product_type;
    }
}
