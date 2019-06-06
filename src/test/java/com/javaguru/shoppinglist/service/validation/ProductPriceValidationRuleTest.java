package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.service.Product;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;


public class ProductPriceValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductPriceValidationRule victim = new ProductPriceValidationRule();
    private Product input;

    private Product product(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);
        return product;
    }

    @Test
    public void shouldValidatePrice() {
        input = product (new BigDecimal(-5));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Price must be a positive number. Try again.");
        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product (new BigDecimal(5));
        victim.validate(input);
    }
}