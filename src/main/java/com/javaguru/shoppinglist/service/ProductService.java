package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Component
public class ProductService {

    private final ProductRepository repository;
    private final ProductValidationService validationService;

    @Autowired
    public ProductService(ProductRepository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    @Transactional
    public Product createProduct(Product product) {
        validationService.validate(product);
        return repository.insert(product);
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(()->new IllegalArgumentException("Product not found, id: "+ id));
    };

    public Product removeProductById (Long id) {
        return repository.delete(id);
    }

    public Product editProductNamebyId (Long id, String name) {
        return repository.changeName(id, name);
    }

    public Product editProductPricebyId (Long id, BigDecimal price) {
        return repository.changePrice(id, price);
    }

    public Product editProductDiscountById (Long id, BigDecimal discount) {
        return repository.changeDiscount(id, discount);
    }

    public Product editProductCategoryById (Long id, String category) {
        return repository.changeCategory(id, category);
    }

    public Product editProductDescriptionById (Long id, String description) {
        return repository.changeDescription(id, description);
    }

}
