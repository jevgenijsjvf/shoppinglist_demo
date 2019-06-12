package com.javaguru.shoppinglist.service;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainService {
    Scanner scanner = new Scanner(System.in);

    public String enterName () {
        System.out.println("Enter product name: ");                 //1
        String name = scanner.nextLine();
        return name;
    }

    public BigDecimal enterPrice() {
        System.out.println("Enter product price: ");                //2
        BigDecimal price = new BigDecimal(scanner.nextLine());
        return price;
    }

    public BigDecimal enterDiscount() {
        System.out.println("Enter product discount (0-80%): ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        return discount;
    }

    public String enterCategory() {
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

    public String enterDescription() {
        System.out.println("Do you need a product description? Enter Y or N ");
        String answer = scanner.nextLine();
        if (answer.equals("Y") || answer.equals("y")) {
            System.out.println("Enter product description: ");
            String description = scanner.nextLine();
            return description;
        } else if (answer.equals("N") || answer.equals("n")) {
            System.out.println("Description no needed.");
            return null;
        } else {
            System.out.println("Wrong answer. Try again.");
            return null;
        }
    }
}
