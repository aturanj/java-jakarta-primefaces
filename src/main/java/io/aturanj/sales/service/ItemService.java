package io.aturanj.sales.service;

import io.aturanj.sales.model.Item;
import io.aturanj.sales.persistence.ItemFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * Use stateless name because of ISalesService
 */
@Stateless(name = "ItemService")
@Local
public class ItemService implements ISalesService<Item> {

    @EJB
    private ItemFacade itemFacade;

    @Override
    public void create(Item entity) {
        itemFacade.create(entity);
    }

    @Override
    public void edit(Item entity) {
        itemFacade.edit(entity);
    }

    @Override
    public void remove(Item entity) {
        itemFacade.remove(entity);
    }

    @Override
    public Item find(Object id) {
        return itemFacade.find(id);
    }

    @Override
    public List<Item> findAll() {
        return itemFacade.findAll();
    }
}
