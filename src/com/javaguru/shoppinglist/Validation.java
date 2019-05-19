package com.javaguru.shoppinglist;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Validation {
    Scanner scanner = new Scanner(System.in);
    String description = null;
    public String description (String answer) {
        if (answer.equals("Y")||answer.equals("y")) {
            System.out.println("Enter product description: ");
            description = scanner.nextLine();
            return description;
        } else if (answer.equals("N")||answer.equals("n")) {
            System.out.println("Description no needed.");
            description = null;
        } else {
            System.out.println("this is end");
            description=null;
        }return description;
    }

    public int discountCheck (int discount) {
         if (discount >0 && discount<80) {
            return discount;
        } else {
            System.out.println("Discount: " + discount);
            System.out.println("Discount must be more than 0 and less than 80.");
            return 0;
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
}
