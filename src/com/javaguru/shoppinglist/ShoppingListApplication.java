package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        Validation validation = new Validation();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                validation.menu();
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        String name = validation.getName();
                        BigDecimal price = validation.getPrice();
                        String category = validation.getCategory();
                        int discount = validation.getDiscount();
                        String description = validation.getDescription();
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setCategoty(category);
                        product.setDiscount(discount);
                        product.setDescription(description);
                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        BigDecimal priceProduct = productRepository.get(id).getPrice();
                        double discountProduct = (double) productRepository.get(id).getDiscount() / 100 + 1;
                        BigDecimal priceWithDiscount = priceProduct.divide(BigDecimal.valueOf(discountProduct), 2, RoundingMode.HALF_UP);
                        System.out.println(findProductResult + " price with discount: " + (priceWithDiscount));
                        break;
                    case 3:
                        System.out.println("Enter product id: ");
                        long id1 = scanner.nextLong();
                        Product findProductResult1 = productRepository.get(id1);
                        System.out.println(findProductResult1);
                        break;
                    case 4:
                        System.out.println("Enter product id: ");
                        long id2 = scanner.nextLong();
                        Product findProductResult2 = productRepository.remove(id2);
                        System.out.println(findProductResult2);
                        break;
                    case 6:
                        System.out.println("It is a test module");
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
