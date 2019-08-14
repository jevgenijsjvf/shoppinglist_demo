package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@Validated({ProductDTO.Create.class})@RequestBody ProductDTO productDTO,
                                          UriComponentsBuilder builder) {
        Long id = productService.createProduct(productDTO);
        return ResponseEntity.created(builder.path("/products/{id}").buildAndExpand(id).toUri()).build();
    }

    @PutMapping ("/{id}/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @PathVariable("shoppingCartId") Long shoppingCartId, @Validated({ProductDTO.Update.class}) @RequestBody ProductDTO productDTO){
       productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {productService.removeProductById(id);}

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNoSuchElementException(NoSuchElementException ex) {

    }


}
