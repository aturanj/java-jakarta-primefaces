package io.aturanj.sales.service;

import io.aturanj.sales.model.Product;
import io.aturanj.sales.persistence.ProductFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ProductService implements ISalesService<Product> {

    @EJB
    private ProductFacade productFacade;

    @Override
    public void create(Product entity) {
        productFacade.create(entity);
    }

    @Override
    public void edit(Product entity) {
        productFacade.edit(entity);
    }

    @Override
    public void remove(Product entity) {
        productFacade.remove(entity);
    }

    @Override
    public Product find(Object id) {
        return productFacade.find(id);
    }

    @Override
    public List<Product> findAll() {
        return productFacade.findAll();
    }
}
