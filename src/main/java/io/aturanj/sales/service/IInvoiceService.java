package io.aturanj.sales.service;

import io.aturanj.sales.model.Invoice;
import java.util.List;

public interface IInvoiceService extends ISalesService<Invoice> {

    public List<Invoice> findByCustomer(Integer customerId);
}
