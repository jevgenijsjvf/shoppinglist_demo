package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.MainService;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create product";
    private final ProductService productService;
    private MainService main = new MainService();

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        String name = main.enterName();
        BigDecimal price = main.enterPrice();
        BigDecimal discount = main.enterDiscount();
        String category = main.enterCategory();
        String description = main.enterDescription();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategoty(category);
        product.setDiscount(discount);
        product.setDescription(description);
        try {
            Product respose = productService.createProduct(product);
            System.out.println("Result: " + respose);
        } catch (ProductValidationException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}


