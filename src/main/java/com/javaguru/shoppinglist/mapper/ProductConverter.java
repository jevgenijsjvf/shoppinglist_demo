package com.javaguru.shoppinglist.mapper;



import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setName(productDTO.getName());
        product.setId(productDTO.getID());
        product.setCategoty(productDTO.getCategoty());
        product.setPrice(productDTO.getPrice());
        product.setDiscount(productDTO.getDiscount());
        return product;
    }

    public ProductDTO convert (Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDescription(product.getDescription());
        productDTO.setName(product.getName());
        productDTO.setID(product.getId());
        productDTO.setCategoty(product.getCategoty());
        productDTO.setPrice(product.getPrice());
        productDTO.setDiscount(product.getDiscount());
        return productDTO;
    }
}
