package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConsoleUIConfiguration {

    @Autowired
    private Action createProductAction;
    @Autowired
    private Action findProductByIdAction;
    @Autowired
    private Action editProductByIdAction;
    @Autowired
    private Action removeProductByIdAction;
    @Autowired
    private Action exitAction;

    @Autowired
    private Action assigProductAction;

    @Bean
    ConsoleUI consoleUI() {
        List<Action> actions=new ArrayList<>();
        actions.add(createProductAction);
        actions.add(findProductByIdAction);
        actions.add(editProductByIdAction);
        actions.add(assigProductAction);
        actions.add(removeProductByIdAction);
        actions.add(exitAction);
        return new ConsoleUI(actions);
    }
}
