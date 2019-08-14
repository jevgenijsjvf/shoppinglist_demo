package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {
    private final ProductRepository repository;

    @Autowired
    public ProductUniqueNameValidationRule(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ProductDTO productDTO) {
        checkNotNull(productDTO);

        if (repository.existsByName(productDTO.getName())) {
            throw new ProductValidationException("Product name must be unique.");
        }
    }
}
