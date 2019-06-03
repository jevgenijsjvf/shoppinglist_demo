package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;

public class ProductService {
    //создали хранилище и сервис валидации
    private ProductInMemoryRepository repository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();

    //этим методом в хранилище помещаем созданный ранее продукт по ид, предварительно выполняя метод из валидации
   // сначала, делаем валидации и потом отправляем в хранилие
    public Long createProduct(Product product) {
        //из сервиса валидации вызываем метод validate для проверки продукта
        validationService.validate(product);
        //получаем введеный пользователем продукт, в репоситории, создаем продукт, там поместит в колекции. вернет продукт который поместил. тут вернется ид введеного продукта.
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
