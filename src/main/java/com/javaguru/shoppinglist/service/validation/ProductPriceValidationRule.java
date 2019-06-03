package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.service.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice().compareTo(BigDecimal.ZERO) > 0) {
        } else {
            throw new ProductValidationException("Price must be a positive number. Try again.");

        }
    }
}
