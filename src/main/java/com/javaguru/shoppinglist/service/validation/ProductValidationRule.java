package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;

public interface ProductValidationRule {
    void validate(ProductDTO productDTO);

    default void checkNotNull (ProductDTO productDTO) {
        if (productDTO == null) {
            throw new ProductValidationException("Product must be not null");
        }
    }
}
