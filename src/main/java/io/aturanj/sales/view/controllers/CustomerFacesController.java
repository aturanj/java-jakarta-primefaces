package io.aturanj.sales.view.controllers;

import io.aturanj.sales.model.Customer;
import io.aturanj.sales.service.ISalesService;
import jakarta.ejb.EJB;
import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named(value = "customerFacesController")
@SessionScoped
public class CustomerFacesController implements Serializable, IFacesController<Customer> {

    @EJB(beanName = "CustomerService")
    private ISalesService<Customer> customerService;

    private List<Customer> customers;

    @Override
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    public List<Customer> getCustomers() {
        customers = findAll();
        return customers;
    }
}
