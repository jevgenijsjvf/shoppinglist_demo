package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule{
    @Override
    public void validate(ProductDTO productDTO) {
        checkNotNull(productDTO);
        if (productDTO.getName() == null) {
            throw new ProductValidationException("Product name must be not null.");
        }
        if (productDTO.getName().length()>3 && productDTO.getName().length()<25) {
         } else {
            throw new ProductValidationException("Name of product must be more than 3 symbol and less than 25 symbol.");
        }
    }
}
