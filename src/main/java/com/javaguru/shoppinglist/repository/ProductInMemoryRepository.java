package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.service.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class ProductInMemoryRepository {
    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product insert (Product product){
        product.setId(productIdSequence++);
        products.put(product.getId(), product);
        return product;
    }

    public Product findProductById (Long id) {
        return products.get(id);
    }

    public Product delete (Long id) {
        Product product = products.get(id);
        products.remove(id);
        return product;
    }

    public Product changeName (Long id, String name) {
        products.get(id).setName(name);
        return products.get(id);
    }

    public Product changePrice (Long id, BigDecimal price) {
        products.get(id).setPrice(price);
        return products.get(id);
    }

    public Product changeDiscount (Long id, int discount) {
        products.get(id).setDiscount(discount);
        return products.get(id);
    }

    public Product changeCategory (Long id, String category) {
        products.get(id).setCategoty(category);
        return products.get(id);
    }

    public Product changeDescription (Long id, String description) {
        products.get(id).setDescription(description);
        return products.get(id);
    }
}
