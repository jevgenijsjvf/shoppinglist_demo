package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.UI.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductUniqueNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.util.HashSet;
import java.util.Set;

class ShoppingListApplication {

    public static void main(String[] args) {

        ProductInMemoryRepository repository = new ProductInMemoryRepository();
        ProductValidationRule productNameValidationRule = new ProductNameValidationRule();
        ProductValidationRule productUniqueNameValidationRule = new ProductUniqueNameValidationRule(repository);
        ProductValidationRule productDiscountValidationRule = new ProductDiscountValidationRule();
        ProductValidationRule productPriceValidationRule = new ProductPriceValidationRule();

        Set<ProductValidationRule> validationRules = new HashSet<>();

        validationRules.add(productNameValidationRule);
        validationRules.add(productUniqueNameValidationRule);
        validationRules.add(productDiscountValidationRule);
        validationRules.add(productPriceValidationRule);

        ProductValidationService validationService = new ProductValidationService(validationRules);
        ProductService productService = new ProductService(repository, validationService);

        ConsoleUI consoleUI = new ConsoleUI(productService);
        consoleUI.execute();
    }
}

