package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
@Profile({"local","dev"})
public class DefaultTaskRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DefaultTaskRepository(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product insert(Product product) {
      String query = "insert into shopinglist (name, price, category, discount, description) values (" + "?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,product.getName());
            ps.setBigDecimal(2,product.getPrice());
            ps.setString(3,product.getCategoty());
            ps.setBigDecimal(4,product.getDiscount());
            ps.setString(5,product.getDescription());
            return ps;
        },keyHolder);

        product.setId(keyHolder.getKey().longValue());
        return product;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        String query = "select * from shopinglist where id="+ id;
        List<Product> shopinglist = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class));
        if (!shopinglist.isEmpty()) {
            return Optional.ofNullable(shopinglist.get(0));
        }
        return Optional.empty();
    }

    @Override
    public Product delete(Long id) {
        String query = "delete from shopinglist where id="+ id;
        List<Product> shopinglist = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class));
        if (!shopinglist.isEmpty()) {
            return shopinglist.get(0);
        }
        return null;
    }

    @Override
    public Product changeName(Long id, String name) {
        String query = "update shopinglist set Name="+name + "where id="+ id;
        List<Product> shopinglist = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class));
        if (!shopinglist.isEmpty()) {
            return shopinglist.get(0);
        }
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
        String query = "SELECT CASE WHEN count(*)> 0 " +
                "THEN true ELSE false END " +
                "FROM shopinglist t where t.name=" + name;
        return jdbcTemplate.queryForObject(query, Boolean.class);
    }
}
