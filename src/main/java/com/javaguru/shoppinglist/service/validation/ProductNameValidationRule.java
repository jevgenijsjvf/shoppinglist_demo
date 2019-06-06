package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.service.Product;

public class ProductNameValidationRule implements ProductValidationRule{
    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("Product name must be not null.");
        }
        if (product.getName().length()>3 && product.getName().length()<25) {
         } else {
            throw new ProductValidationException("Name of product must be more than 3 symbol and less than 30 symbol.");
        }
    }
}
