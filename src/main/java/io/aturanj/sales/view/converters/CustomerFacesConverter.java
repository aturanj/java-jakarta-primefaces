package io.aturanj.sales.view.converters;

import io.aturanj.sales.model.Customer;
import io.aturanj.sales.service.ISalesService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Customer.class)
public class CustomerFacesConverter implements Converter {

    @EJB(beanName = "CustomerService")
    private ISalesService<Customer> customerService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Customer) value).toString();
        }
        return null;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        Customer customer = null;

        if (string != null && !"".equals(string)) {
            customer = this.customerService.find(new Integer(string));
        }

        return customer;
    }
}
