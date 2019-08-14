package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {
    private final int minDiscountValue = 0;
    private final int maxDiscountValue = 80;

    @Override
    public void validate(ProductDTO productDTO) {
        checkNotNull(productDTO);
        if (productDTO.getDiscount().compareTo(BigDecimal.valueOf(minDiscountValue)) >= 0 && productDTO.getDiscount().compareTo(BigDecimal.valueOf(maxDiscountValue)) < 0)
        {
        } else {
            throw new ProductValidationException("Discount must be more than 0 and less than 80. Try again.");

        }
    }
}
