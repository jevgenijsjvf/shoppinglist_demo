package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveProductByIdAction implements Action{
    private static final String ACTION_NAME = "Remove by ID";
    private final ProductService productService;

    public RemoveProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        Product product = productService.removeProductById(id);
        System.out.println("Removed products: "+product);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
