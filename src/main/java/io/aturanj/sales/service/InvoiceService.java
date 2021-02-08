package io.aturanj.sales.service;

import io.aturanj.sales.model.Invoice;
import io.aturanj.sales.persistence.InvoiceFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class InvoiceService implements ISalesService<Invoice> {

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
}
