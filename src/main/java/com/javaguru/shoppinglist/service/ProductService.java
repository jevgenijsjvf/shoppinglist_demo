package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductValidationService validationService;
    private final ProductConverter productConverter;

    @Autowired
    public ProductService(ProductRepository repository, ProductValidationService validationService, ProductConverter productConverter) {
        this.repository = repository;
        this.validationService = validationService;
        this.productConverter = productConverter;
    }


    public Long createProduct(ProductDTO productDTO) {
        validationService.validate(productDTO);
        Product product = productConverter.convert(productDTO);
        return repository.insert(product);
    }

    public ProductDTO findProductById(Long id) {
        return repository.findProductById(id).map(productConverter::convert)
                .orElseThrow(()->new NoSuchElementException("Product not found, id: "+ id));
    }

    public void updateProduct(ProductDTO productDTO) {
        Product product = productConverter.convert(productDTO);
        repository.insert(product);
    }
    @Transactional
    public void removeProductById (Long id) {
        repository.findProductById(id).ifPresent(repository::delete);
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
