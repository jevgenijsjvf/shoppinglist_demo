package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.service.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductNameValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductNameValidationRule victim = new ProductNameValidationRule();
    private Product input;

    @Test
    public void shouldThrowTaskValidationException() {
        input = product (null);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name must be not null.");
        victim.validate(input);
    }
    @Test
    public void shouldValidateSuccess() {
        input=product("Valid name");
        victim.validate(input);
    }

    @Test
    public void shoudBeLenghtLess() {
        input=product("aa");
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Name of product must be more than 3 symbol and less than 30 symbol.");
        victim.validate(input);
    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}