package io.aturanj.sales.view.controllers;

import io.aturanj.sales.model.Customer;
import io.aturanj.sales.service.ISalesService;
import jakarta.ejb.EJB;
import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.primefaces.model.FilterMeta;

@Named(value = "customerFacesController")
@SessionScoped
public class CustomerFacesController implements Serializable, IFacesController<Customer> {

    @EJB(beanName = "CustomerService")
    private ISalesService<Customer> customerService;

    private List<Customer> customers;
    private List<Customer> customersFiltered;
    private int customerCount;
    private List<FilterMeta> filterBy;

    @Override
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    public List<Customer> getCustomers() {
        customers = findAll();
        customerCount = customers.size();
        return customers;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public List<Customer> getCustomersFiltered() {
        return customersFiltered;
    }

    public void setCustomersFiltered(List<Customer> customersFiltered) {
        this.customersFiltered = customersFiltered;
    }

    public List<FilterMeta> getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(List<FilterMeta> filterBy) {
        this.filterBy = filterBy;
    }
}
