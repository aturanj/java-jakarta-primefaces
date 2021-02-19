package io.aturanj.sales.persistence;

import io.aturanj.sales.model.Invoice;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class InvoiceFacade extends AbstractFacade<Invoice> {

    @PersistenceContext(unitName = "io.aturanj.jakarta.pu")
    private EntityManager em;

    public InvoiceFacade() {
        super(Invoice.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Invoice> findByCustomer(Integer customerId) {

        Query query = em.createNamedQuery("Invoice.findByCustomerId");
        query.setParameter("id", customerId);

        return query.getResultList();
    }
}
