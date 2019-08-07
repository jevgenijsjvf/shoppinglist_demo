package com.javaguru.shoppinglist.dto;

import java.math.BigDecimal;

public class ProductDTO {

    private Long ID;
    private String name;
    private BigDecimal price;
    private String categoty;
    private BigDecimal discount;
    private String description;

    public ProductDTO(Long ID, String name, BigDecimal price, String categoty, BigDecimal discount, String description) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.categoty = categoty;
        this.discount = discount;
        this.description = description;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategoty() {
        return categoty;
    }

    public void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
