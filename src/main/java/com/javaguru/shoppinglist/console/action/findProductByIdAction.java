package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class findProductByIdAction implements Action{

    private static final String ACTION_NAME = "Find by ID";
    private final ProductService productService;
    private int minDiscountPrice = 20;

    public findProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        System.out.println("Response: " + product);
        BigDecimal priceProduct = productService.findProductById(id).getPrice();
        BigDecimal discountProduct = productService.findProductById(id).getDiscount();
        BigDecimal discountSum = (priceProduct.divide(BigDecimal.valueOf(100))).multiply(discountProduct);
        BigDecimal priceWithDiscount = priceProduct.subtract(discountSum);
        System.out.print (product + " price with discount: ");
        if(product.getPrice().compareTo(BigDecimal.valueOf(minDiscountPrice))> 0) {
            System.out.println(priceWithDiscount);
        } else {
            System.out.println("Discount not allowed");
        }
    }
}
