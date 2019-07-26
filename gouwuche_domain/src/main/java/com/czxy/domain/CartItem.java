package com.czxy.domain;

/**
 * @author 刘昌燊
 * @version v 1.0
 * @date 2019/7/22
 */
public class CartItem {
    private Product product;
    private Integer count;

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", count=" + count +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CartItem(Product product, Integer count) {
        this.product = product;
        this.count = count;
    }

    public CartItem() {
    }
}
