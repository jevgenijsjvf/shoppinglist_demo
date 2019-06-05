package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;

public class ProductService {

    private ProductInMemoryRepository repository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.insert(product) ;
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id);
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

    public Product editProductDiscountById (Long id, int discount) {
        return repository.changeDiscount(id, discount);
    }

    public Product editProductCategoryById (Long id, String category) {
        return repository.changeCategory(id, category);
    }

    public Product editProductDescriptionById (Long id, String description) {
        return repository.changeDescription(id, description);
    }

}
