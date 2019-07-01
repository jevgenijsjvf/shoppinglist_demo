package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Component
public class ProductService {

    private final ProductInMemoryRepository repository;
    private final ProductValidationService validationService;

    @Autowired
    public ProductService(ProductInMemoryRepository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.insert(product) ;
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(()->new NoSuchElementException("Product not found, id: "+ id));
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
