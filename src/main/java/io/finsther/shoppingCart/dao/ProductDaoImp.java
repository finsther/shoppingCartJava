package io.finsther.shoppingCart.dao;

import io.finsther.shoppingCart.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImp implements ProductDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Product findBy(Long id) {
        String queryString = "FROM Product WHERE id = :id";
        return (Product) entityManager
                .createQuery(queryString)
                .setParameter("id", id)
                .getResultList().get(0);
    }

    @Override
    public List<Product> getAll() {
        String query = "FROM Product";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void register(Product product) {
        entityManager.merge(product);
    }
}
