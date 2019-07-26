package com.czxy.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘昌燊
 * @version v 1.0
 * @date 2019/7/22
 */
public class Cart {
    private Map<Integer, CartItem> map = new HashMap<>();

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                '}';
    }

    public Cart(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public Cart() {
    }

    //添加
    public void addCartItem(Product product, Integer count) {
        //通过商品id去map获取购物车商品对象
        CartItem cartItem = map.get(product.getId());
        if (cartItem == null) {
            cartItem = new CartItem(product, count);
        } else {
            //不为空+1
            cartItem.setCount(cartItem.getCount() + count);
        }
        //更新map
        map.put(product.getId(), cartItem);

    }


    //删除 执行一次 count -1
    public void deleteItem(Product product) {
        CartItem cartItem = map.get(product.getId());

        cartItem.setCount(cartItem.getCount() - 1);

        map.put(product.getId(), cartItem);
    }
}
