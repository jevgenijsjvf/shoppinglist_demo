package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.service.Product;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getDiscount() >= 0 && product.getDiscount() < 80) {
        } else {
            throw new ProductValidationException("Discount must be more than 0 and less than 80. Try again.");

        }
    }
}
