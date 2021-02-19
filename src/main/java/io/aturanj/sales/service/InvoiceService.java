package io.aturanj.sales.service;

import io.aturanj.sales.model.Invoice;
import io.aturanj.sales.persistence.InvoiceFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * Use stateless name because of ISalesService
 */
@Stateless(name = "InvoiceService")
@Local
public class InvoiceService implements IInvoiceService {

    @EJB
    private InvoiceFacade invoiceFacade;

    @Override
    public void create(Invoice entity) {
        invoiceFacade.create(entity);
    }

    @Override
    public void edit(Invoice entity) {
        invoiceFacade.edit(entity);
    }

    @Override
    public void remove(Invoice entity) {
        invoiceFacade.remove(entity);
    }

    @Override
    public Invoice find(Object id) {
        return invoiceFacade.find(id);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceFacade.findAll();
    }

    @Override
    public List<Invoice> findByCustomer(Integer customerId) {
        return invoiceFacade.findByCustomer(customerId);
    }
}
