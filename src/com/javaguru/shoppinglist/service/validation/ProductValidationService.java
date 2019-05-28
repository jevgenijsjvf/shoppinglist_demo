package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.service.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    //HashSet с правилами
    private Set<ProductValidationRule> validationRules = new HashSet<>();
    //метод, добавляющий правила
    public  ProductValidationService() {

        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductPriceValidationRule());
    }

    //производит проверку
    public void validate (Product product){

        validationRules.forEach(s -> s.validate(product));
    }

}
