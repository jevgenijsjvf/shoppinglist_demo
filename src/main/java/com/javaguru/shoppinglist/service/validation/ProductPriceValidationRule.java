package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDTO productDTO) {
        checkNotNull(productDTO);
        if (productDTO.getPrice().compareTo(BigDecimal.ZERO) > 0) {
        } else {
            throw new ProductValidationException("Price must be a positive number. Try again.");

        }
    }
}
