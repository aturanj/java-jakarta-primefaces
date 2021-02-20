package io.aturanj.sales.view.controllers;

import io.aturanj.sales.model.Customer;
import io.aturanj.sales.model.Invoice;
import io.aturanj.sales.service.IInvoiceService;
import jakarta.ejb.EJB;
import java.io.Serializable;
import java.util.List;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

@Named(value = "invoiceFacesController")
@ViewScoped
public class InvoiceFacesController implements Serializable, IFacesController<Invoice> {

    @EJB(beanName = "InvoiceService")
    private IInvoiceService invoiceService;

    private List<Invoice> invoices;
    private List<Invoice> invoicesByCustomer;

    private int invoiceCount;

    @Override
    public List<Invoice> findAll() {
        return invoiceService.findAll();
    }

    public List<Invoice> getInvoices() {
        invoices = findAll();
        invoiceCount = invoices.size();
        return invoices;
    }

    public int getInvoiceCount() {
        return invoiceCount;
    }

    public List<Invoice> getInvoicesByCustomer() {
        return invoicesByCustomer;
    }

    public void setInvoicesByCustomer(List<Invoice> invoicesByCustomer) {
        this.invoicesByCustomer = invoicesByCustomer;
    }

    public void onRowToggle(ToggleEvent event) {

        if (event.getVisibility() == Visibility.VISIBLE) {

            if (event.getData() != null) {
                invoicesByCustomer = invoiceService.findByCustomer(((Customer) event.getData()).getId());
                invoiceCount = invoices.size();
            }
        }
    }
}
