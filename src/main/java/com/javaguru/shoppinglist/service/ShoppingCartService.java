package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.HibernateShopingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ShoppingCartService {
    private final HibernateShopingCartRepository shopingCartRepository;

    @Autowired
    public ShoppingCartService(HibernateShopingCartRepository shopingCartRepository) {
        this.shopingCartRepository = shopingCartRepository;
    }

    public Long createShoppingCart(ShoppingCart shoppingCart) {
        return shopingCartRepository.insert(shoppingCart);
    }

    public ShoppingCart findShoppingCartById (Long shoppingCartId) {
        return shopingCartRepository.findShoppingCartByID(shoppingCartId)
                .orElseThrow(()->new NoSuchElementException("ShoppingCart not found, id: "+ shoppingCartId));
    }

    public void addProductToShoppingCart (Product product, Long shoppingCartId) {
        ShoppingCart shoppingCart = findShoppingCartById(shoppingCartId);
        shoppingCart.getProducts().add(product);
        shopingCartRepository.update(shoppingCart);
    }
}
