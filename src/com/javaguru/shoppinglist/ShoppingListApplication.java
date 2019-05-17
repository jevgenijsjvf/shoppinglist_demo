package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Edit product by id");
                System.out.println("4. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        System.out.println("Enter product discount: ");
                        int discount = scanner.nextInt();
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
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        System.out.println("Enter product id: ");
                        long id1 = scanner.nextLong();
                        Product findProductResult1 = productRepository.get(id1);
                        System.out.println(findProductResult1);
                        break;
                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
