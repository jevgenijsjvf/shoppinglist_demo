package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.service.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ProductDiscountValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();
    private Product input;

    private Product product(int discount) {
        Product product = new Product();
        product.setDiscount(discount);
        return product;
    }
    @Test
    public void shouldValidateDiscount() {
        input = product (-5);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Discount must be more than 0 and less than 80. Try again.");
        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product (10);
        victim.validate(input);
    }
}