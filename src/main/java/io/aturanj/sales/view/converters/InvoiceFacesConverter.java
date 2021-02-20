package io.aturanj.sales.view.converters;

import io.aturanj.sales.model.Invoice;
import io.aturanj.sales.service.IInvoiceService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Invoice.class)
public class InvoiceFacesConverter implements Converter {

    @EJB(beanName = "InvoiceService")
    private IInvoiceService invoiceService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Invoice) value).toString();
        }
        return null;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        Invoice invoice = null;

        if (string != null && !"".equals(string)) {
            invoice = this.invoiceService.find(new Integer(string));
        }

        return invoice;
    }
}
