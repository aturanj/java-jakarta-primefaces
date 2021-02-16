package io.aturanj.sales.service;

import io.aturanj.sales.model.Customer;
import io.aturanj.sales.persistence.CustomerFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.util.Collection;
import java.util.List;

/**
 *
 * Use stateless name because of ISalesService
 */
@Stateless(name = "CustomerService")
@Local
public class CustomerService implements ICustomerService {

    @EJB
    private CustomerFacade customerFacade;

    @Override
    public void create(Customer entity) {
        customerFacade.create(entity);
    }

    @Override
    public void edit(Customer entity) {
        customerFacade.edit(entity);
    }

    @Override
    public void remove(Customer entity) {
        customerFacade.remove(entity);
    }

    @Override
    public Customer find(Object id) {
        return customerFacade.find(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerFacade.findAll();
    }

    public Collection<String> findAllCities() {

        return customerFacade.findAllCities();
    }
}
