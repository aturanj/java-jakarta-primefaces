package io.aturanj.sales.view.controllers;

import io.aturanj.sales.model.Customer;
import io.aturanj.sales.service.ICustomerService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.Collection;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@Named(value = "customerFacesController")
@ViewScoped
public class CustomerFacesController implements Serializable, IFacesController<Customer> {

    @EJB(beanName = "CustomerService")
    private ICustomerService customerService;

    private List<Customer> customers;
    private int customerCount;
    private Collection<String> cityList;
    private Customer selectedCustomer;

    @PostConstruct
    private void init() {
        cityList = customerService.findAllCities();
    }

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

    public void onRowEdit(RowEditEvent<Customer> event) {
        FacesMessage msg = new FacesMessage("Customer Edited", "Customer: "
                + String.valueOf(event.getObject().getFirstname() + " "
                        + event.getObject().getLastname()));
        FacesContext.getCurrentInstance().addMessage(null, msg);

        customerService.edit(event.getObject());
    }

    public void onRowCancel(RowEditEvent<Customer> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", "Customer: "
                + String.valueOf(event.getObject().getFirstname() + " "
                        + event.getObject().getLastname()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Collection<String> getCityList() {
        return cityList;
    }

    public void setCityList(Collection<String> cityList) {
        this.cityList = cityList;
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public void onRowSelect(SelectEvent<Customer> event) {
        FacesMessage msg = new FacesMessage("Customer Selected", String.valueOf(event.getObject().getFirstname() + " "
                + event.getObject().getLastname()));
        FacesContext.getCurrentInstance().addMessage(null, msg);

        setSelectedCustomer(event.getObject());
    }

    public void onRowUnselect(UnselectEvent<Customer> event) {
        FacesMessage msg = new FacesMessage("Customer Unselected", String.valueOf(event.getObject().getFirstname() + " "
                + event.getObject().getLastname()));
        FacesContext.getCurrentInstance().addMessage(null, msg);

        setSelectedCustomer(null);
    }
}
