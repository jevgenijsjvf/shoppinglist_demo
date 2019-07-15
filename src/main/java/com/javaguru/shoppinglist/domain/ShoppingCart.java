package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shoppingCarts")
public class ShoppingCart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="cartName", nullable = false)
    private String cartName;
    @Column(name="cartDescription", nullable = false)
    private String cartDescription;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_id")
    private Set<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public String getCartDescription() {
        return cartDescription;
    }

    public void setCartDescription(String cartDescription) {
        this.cartDescription = cartDescription;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cartName, that.cartName) &&
                Objects.equals(cartDescription, that.cartDescription) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cartName, cartDescription, products);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", cartName='" + cartName + '\'' +
                ", cartDescription='" + cartDescription + '\'' +
                ", products=" + products +
                '}';
    }
}
