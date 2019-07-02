package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductDiscountValidationRuleTest {

    @Spy
    private ProductDiscountValidationRule victim;
    private Product input;

    private Product product(BigDecimal discount) {
        Product product = new Product();
        product.setDiscount(discount);
        return product;
    }
    @Test
    public void shouldThrowProductDiscountValidateException() {
        input = product (new BigDecimal((-5)));
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Discount must be more than 0 and less than 80. Try again.");
        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product (new BigDecimal(10));
        victim.validate(input);
        verify(victim).checkNotNull(input);
    }
}