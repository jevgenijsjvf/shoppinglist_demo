package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class Validation {
    Scanner scanner = new Scanner(System.in);
    String description = null;

    public String getDescription() {
        System.out.println("Do you need a product description? Enter Y or N ");
        String answer = scanner.nextLine();
        if (answer.equals("Y") || answer.equals("y")) {
            System.out.println("Enter product description: ");
            description = scanner.nextLine();
            return description;
        } else if (answer.equals("N") || answer.equals("n")) {
            System.out.println("Description no needed.");
            return null;
        } else {
            System.out.println("Wrong answer. Try again.");
            return getDescription();
        }

    }

    public void menu() {
        System.out.println("1. Create product");
        System.out.println("2. Find product by id");
        System.out.println("3. Edit product by id");
        System.out.println("4. Remove product by id");
        System.out.println("6. My test case");
        System.out.println("5. Exit");
    }

    public String getName() {
        System.out.println("Enter product name: ");
        String name1 = scanner.nextLine();
        if (name1.length() > 3 && name1.length() < 30) {
            return name1;
        } else {
            System.out.println("Name of product must be more than 3 symbol and less than 30 symbol. Try again.");
            return getName();
        }
    }

    public BigDecimal getPrice() {
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            return price;
        } else {
            System.out.println("Price must be a positive number. Try again.");
            return getPrice();
        }
    }

    public int getDiscount() {
        System.out.println("Enter product discount (0-80%): ");
        int discount = scanner.nextInt();
        if (discount >= 0 && discount < 80) {
            return discount;
        } else {
            System.out.println("Discount must be more than 0 and less than 80. Try again.");
            return getDiscount();
        }
    }

    public String getCategory() {
        while (true) {
            try {
                System.out.println("Choose a category: ");
                System.out.println("1. Meat");
                System.out.println("2. Vegetables");
                System.out.println("3. Fruits");
                System.out.println("4. Milk");
                System.out.println("5. Alcohol");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        return "Meat";
                    case 2:
                        return "Vegetables";
                    case 3:
                        return "Fruits";
                    case 4:
                        return "Milk";
                    case 5:
                        return "Alcohol";
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

}