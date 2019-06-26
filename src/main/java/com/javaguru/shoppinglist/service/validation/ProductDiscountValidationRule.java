package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.service.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {
    private int minDiscountValue = 0;
    private int maxDiscountValue = 80;

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getDiscount().compareTo(BigDecimal.valueOf(minDiscountValue)) >= 0 && product.getDiscount().compareTo(BigDecimal.valueOf(maxDiscountValue)) < 0)
        {
        } else {
            throw new ProductValidationException("Discount must be more than 0 and less than 80. Try again.");

        }
    }
}
