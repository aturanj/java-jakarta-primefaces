package io.aturanj.sales.persistence;

import io.aturanj.sales.model.Item;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ItemFacade extends AbstractFacade<Item> {

    @PersistenceContext(unitName = "io.aturanj.jakarta.pu")
    private EntityManager em;

    public ItemFacade() {
        super(Item.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
