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
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@Named(value = "customerFacesController")
@ViewScoped
public class CustomerFacesController implements Serializable, IFacesController<Customer> {

    @EJB(beanName = "CustomerService")
    private ICustomerService customerService;

    private List<Customer> customers;
    private int customerCount;
    private Collection<String> cityList;

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
    }

    public void onRowCancel(RowEditEvent<Customer> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", "Customer: "
                + String.valueOf(event.getObject().getFirstname() + " "
                        + event.getObject().getLastname()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Collection<String> getCityList() {
        return cityList;
    }

    public void setCityList(Collection<String> cityList) {
        this.cityList = cityList;
    }

}
