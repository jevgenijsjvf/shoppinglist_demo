package com.javaguru.shoppinglist;

import java.math.BigDecimal;
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
                        double discountProduct = (double) productRepository.get(id).getDiscount();
                        BigDecimal discountSum = (priceProduct.divide(BigDecimal.valueOf(100))).multiply(BigDecimal.valueOf(discountProduct));
                        BigDecimal priceWithDiscount = priceProduct.subtract(discountSum);
                        System.out.println(findProductResult + " price with discount: " + (priceWithDiscount));
                        break;
                    case 3:

                        System.out.println("Enter product id: ");
                        long idEdit = scanner.nextLong();
                        System.out.println("What you want to change: ");
                        System.out.println("1. Change name");
                        System.out.println("2. Change price");
                        System.out.println("3. Change category");
                        System.out.println("4. Change discount");
                        System.out.println("5. Change description");
                        System.out.println("6. Exit");
                        try {
                            Integer userInputChange = Integer.valueOf(scanner.nextInt());
                            switch (userInputChange) {
                                case 1:
                                    String nameEdit = validation.getName();
                                    productRepository.get(idEdit).setName(nameEdit);
                                    break;
                                case 2:
                                    BigDecimal priceEdit = validation.getPrice();
                                    productRepository.get(idEdit).setPrice(priceEdit);
                                    break;
                                case 3:
                                    String categoryEdit = validation.getCategory();
                                    productRepository.get(idEdit).setCategoty(categoryEdit);
                                    break;
                                case 4:
                                    int discountEdit = validation.getDiscount();
                                    productRepository.get(idEdit).setDiscount(discountEdit);
                                    break;
                                case 5:
                                    String descriptionEdit = validation.getDescription();
                                    productRepository.get(idEdit).setDescription(descriptionEdit);
                                    break;
                                case 6:
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("Error! Please try again.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter product id: ");
                        long idRemove = scanner.nextLong();
                        Product findProductResult2 = productRepository.remove(idRemove);
                        System.out.println(findProductResult2);
                        break;
//                    case 6:
//                        System.out.println("It is a test module");
//                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
