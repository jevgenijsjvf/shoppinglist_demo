package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.Domain.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceValidationRuleTest {

    @Spy
    private ProductPriceValidationRule victim;
    private Product input;

    private Product product(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);
        return product;
    }

    @Test
    public void shouldThrowProductPriceValidationException() {
        input = product (new BigDecimal(-5));
        assertThatThrownBy(()-> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Price must be a positive number. Try again.");
        verify(victim).checkNotNull(input);

    }

    @Test
    public void shouldValidateSuccess() {
        input = product (new BigDecimal(5));
        victim.validate(input);
        verify(victim).checkNotNull(input);
    }
}