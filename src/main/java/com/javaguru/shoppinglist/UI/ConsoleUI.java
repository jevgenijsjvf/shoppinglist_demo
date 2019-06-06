package com.javaguru.shoppinglist.UI;

import com.javaguru.shoppinglist.service.MainService;
import com.javaguru.shoppinglist.service.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {
  private   ProductService productService = new ProductService();
  private MainService main = new MainService();

    public void  execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Edit product by id");
                System.out.println("4. Remove product by id");
                System.out.println("5. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProduct();
                        break;
                    case 3:
                        editProduct();
                        break;
                    case 4:
                        removeProduct();
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createProduct() {
        Scanner scanner = new Scanner(System.in);
        String name = main.enterName();                             //1
        BigDecimal price = main.enterPrice();                       //2
        int discount = main.enterDiscount();                        //3
        String category = main.enterCategory();                            //4
        String description = main.enterDescription();                      //5

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategoty(category);
        product.setDiscount(discount);
        product.setDescription(description);

        Long id = productService.createProduct(product);
        System.out.println("Result: " + product.getId());
    }

    public void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        BigDecimal priceProduct = productService.findProductById(id).getPrice();
        double discountProduct = (double) productService.findProductById(id).getDiscount();
        BigDecimal discountSum = (priceProduct.divide(BigDecimal.valueOf(100))).multiply(BigDecimal.valueOf(discountProduct));
        BigDecimal priceWithDiscount = priceProduct.subtract(discountSum);
        System.out.println(product + " price with discount: " + (priceWithDiscount));
    }

    public void editProduct() {
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
            Integer userInputChange = Integer.valueOf(scanner.nextInt());
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
                    int discount = main.enterDiscount();
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
            System.out.println("Error! Please try again.");
        }
    }

    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        Product product = productService.removeProductById(id);
        System.out.println("Removed products: "+product);
    }


}
