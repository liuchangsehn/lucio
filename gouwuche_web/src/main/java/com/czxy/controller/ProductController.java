package com.czxy.controller;

import com.czxy.domain.Cart;
import com.czxy.domain.CartItem;
import com.czxy.domain.Product;
import com.czxy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 刘昌燊
 * @version v 1.0
 * @date 2019/7/22
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 展示所有
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        try {
            List<Product> all = productService.findAll();
            for (Product product : all) {
                System.out.println(product);
            }
            return new ResponseEntity<>(all, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * 添加到购物车
     * @param id
     * @param session
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cart> addCart(@PathVariable("id") String id, HttpSession session) {

        System.out.println(id);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Product product = productService.findById(Integer.parseInt(id));
        System.out.println(product);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        cart.addCartItem(product, 1);
        System.out.println(cart);
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    /**
     * 展示购物车
     * @param session
     * @return
     */
    @GetMapping("/findAllByCart")
    public ResponseEntity<List<CartItem>> findCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            List<CartItem> cartItemList = new ArrayList<>();
            Map<Integer, CartItem> map = cart.getMap();
            Set<Integer> keySet = map.keySet();
            for (Integer key : keySet) {
                cartItemList.add(map.get(key));
            }
            return new ResponseEntity<>(cartItemList, HttpStatus.OK);
        }
    }

    /**
     * 删除
     * @param id
     * @param session
     * @return
     */
    @GetMapping("del/{id}")
    public ResponseEntity<List<CartItem>> delById(@PathVariable("id") Integer id, HttpSession session) {
        Product product = productService.findById(id);
        Cart cart = (Cart) session.getAttribute("cart");
        cart.deleteItem(product);
        Map<Integer, CartItem> cartMap = cart.getMap();
        CartItem cartItem = cartMap.get(product.getId());
        if (cartItem.getCount()==0){
            cartMap.remove(product.getId());
        }
        System.out.println(cart);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            List<CartItem> cartItemList = new ArrayList<>();
            Map<Integer, CartItem> map = cart.getMap();
            Set<Integer> keySet = map.keySet();
            for (Integer key : keySet) {
                cartItemList.add(map.get(key));
            }
            return new ResponseEntity<>(cartItemList, HttpStatus.OK);
        }

    }
}
