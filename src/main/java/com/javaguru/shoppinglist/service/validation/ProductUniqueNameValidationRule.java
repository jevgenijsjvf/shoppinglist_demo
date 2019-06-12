package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.Product;

public class ProductUniqueNameValidationRule implements ProductValidationRule {
   // ProductService service = new ProductService();
    private final ProductInMemoryRepository repository;

    public ProductUniqueNameValidationRule(ProductInMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);

        if (repository.existsByName(product.getName())) {
            throw new ProductValidationException("Product name must be unique.");
        }
    }
}
