package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Profile("inmemorydb")
public class ProductInMemoryRepository implements ProductRepository{
    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product insert(Product product){
        product.setId(productIdSequence++);
        products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findProductById (Long id) {
      return Optional.ofNullable(products.get(id));
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

    public Product changeDiscount (Long id, BigDecimal discount) {
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

    public Boolean existsByName (String name) {
        return products.values().stream().anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }
}
