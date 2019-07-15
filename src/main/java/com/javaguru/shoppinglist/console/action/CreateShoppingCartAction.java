package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.Scanner;

@Component
public class CreateShoppingCartAction implements Action{
    private static final String ACTION_NAME="Create shopping cart";
    private final ShoppingCartService shoppingCartService;

    public CreateShoppingCartAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shopping cart name: ");
        String name=scanner.nextLine();
        System.out.println("Enter shopping cart description: ");
        String description = scanner.nextLine();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartName(name);
        shoppingCart.setCartDescription(description);

        Long response = shoppingCartService.createShoppingCart(shoppingCart);
        System.out.println("Response: "+ response);

    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
