package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductRepository {
    Product insert(Product product);
    public Optional<Product> findProductById (Long id);
    public Product delete (Long id);
    public Product changeName (Long id, String name);
    public Product changePrice (Long id, BigDecimal price);
    public Product changeDiscount (Long id, BigDecimal discount);
    public Product changeCategory (Long id, String category);
    public Product changeDescription (Long id, String description);
    public Boolean existsByName (String name);

}