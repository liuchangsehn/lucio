package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 刘昌燊
 * @version v 1.0
 * @date 2019/7/22
 * CREATE TABLE product(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	`name` VARCHAR(32),
 * 	`type` VARCHAR(32),
 * 	price VARCHAR(10)
 * );
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    private Integer id;
    private String name;
    private String type;
    private String price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
