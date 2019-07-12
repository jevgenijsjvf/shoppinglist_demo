package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
@Profile("jdbc")
public class JdbcProductRepository implements ProductRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product insert(Product product) {
        return null;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public Product delete(Long id) {
        return null;
    }

    @Override
    public Product changeName(Long id, String name) {
        return null;
    }

    @Override
    public Product changePrice(Long id, BigDecimal price) {
        return null;
    }

    @Override
    public Product changeDiscount(Long id, BigDecimal discount) {
        return null;
    }

    @Override
    public Product changeCategory(Long id, String category) {
        return null;
    }

    @Override
    public Product changeDescription(Long id, String description) {
        return null;
    }

    @Override
    public Boolean existsByName(String name) {
        return null;
    }
}
