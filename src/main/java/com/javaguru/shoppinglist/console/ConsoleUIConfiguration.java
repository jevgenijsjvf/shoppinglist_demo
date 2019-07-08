package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConsoleUIConfiguration {

    private final Action createProductAction;
    private final Action findProductByIdAction;
    private final Action editProductByIdAction;
    private final Action removeProductByIdAction;
    private final Action exitAction;

    @Autowired
    public ConsoleUIConfiguration(Action createProductAction, Action findProductByIdAction, Action editProductByIdAction, Action removeProductByIdAction, Action exitAction) {
        this.createProductAction = createProductAction;
        this.findProductByIdAction = findProductByIdAction;
        this.editProductByIdAction = editProductByIdAction;
        this.removeProductByIdAction = removeProductByIdAction;
        this.exitAction = exitAction;
    }

    @Bean
    ConsoleUI consoleUI() {
        List<Action> actions=new ArrayList<>();
        actions.add(createProductAction);
        actions.add(findProductByIdAction);
        actions.add(editProductByIdAction);
        actions.add(removeProductByIdAction);
        actions.add(exitAction);
        return new ConsoleUI(actions);
    }
}
