package io.aturanj.sales.persistence;

import io.aturanj.sales.model.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.Collection;

@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "io.aturanj.jakarta.pu")
    private EntityManager em;

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Collection<String> findAllCities() {

        return em.createNamedQuery("Customer.findAllCities").getResultList();
    }
}
