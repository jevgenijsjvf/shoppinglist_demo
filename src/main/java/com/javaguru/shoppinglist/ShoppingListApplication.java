package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.Config.AppConfig;
import com.javaguru.shoppinglist.UI.ConsoleUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShoppingListApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleUI console = context.getBean(ConsoleUI.class);
        console.execute();
    }
}

