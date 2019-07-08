package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateProductRepository implements ProductRepository{
    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product insert(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public Product delete(Long id) {
        //Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)

        sessionFactory.getCurrentSession().delete(Restrictions.eq("id",id));
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
        String query = "select case when count(*)>0 "+
                "then rule else false end " +
                "from Task t where t.name= '" + name + "'";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setMaxResults(1)
                .uniqueResult();
    }

    public List<Product> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class)
                .list();
    }

    public void delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }
}
