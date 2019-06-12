package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.service.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getDiscount().compareTo(BigDecimal.valueOf(0)) >= 0 && product.getDiscount().compareTo(BigDecimal.valueOf(80)) < 0)
        {
        } else {
            throw new ProductValidationException("Discount must be more than 0 and less than 80. Try again.");

        }
    }
}
