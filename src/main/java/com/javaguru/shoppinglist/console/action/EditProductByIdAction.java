package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.service.MainService;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class EditProductByIdAction implements Action{

    private static final String ACTION_NAME = "Edit by ID";
    private final ProductService productService;
    private MainService main = new MainService();

    public EditProductByIdAction(ProductService productService) {
                this.productService = productService;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        System.out.println("What you want to change: ");
        System.out.println("1. Change name");
        System.out.println("2. Change price");
        System.out.println("3. Change discount");
        System.out.println("4. Change category");
        System.out.println("5. Change description");
        System.out.println("6. Exit");
        try {
            Integer userInputChange = scanner.nextInt();
            switch (userInputChange) {
                case 1:
                    String name = main.enterName();
                    productService.editProductNamebyId(id, name);
                    break;
                case 2:
                    BigDecimal price = main.enterPrice();
                    productService.editProductPricebyId(id,price);
                    break;
                case 3:
                    BigDecimal discount = main.enterDiscount();
                    productService.editProductDiscountById(id, discount);
                    break;
                case 4:
                    String category = main.enterCategory();
                    productService.editProductCategoryById(id,category);
                    break;
                case 5:
                    String description = main.enterDescription();
                    productService.editProductDescriptionById(id, description);
                    break;
                case 6:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error!!! Please try again.");
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
