package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductRepository {

    Long insert(Product product);

    ProductDTO insert(ProductDTO productDTO);

    Optional<Product> findProductById (Long id);
    void delete (Product product);

    Product delete(Long id);

    Product changeName (Long id, String name);
    Product changePrice (Long id, BigDecimal price);
    Product changeDiscount (Long id, BigDecimal discount);
    Product changeCategory (Long id, String category);
    Product changeDescription (Long id, String description);
    Boolean existsByName (String name);

}