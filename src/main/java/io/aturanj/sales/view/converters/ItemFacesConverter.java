package io.aturanj.sales.view.converters;

import io.aturanj.sales.model.Item;
import io.aturanj.sales.service.ISalesService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Item.class)
public class ItemFacesConverter implements Converter {

    @EJB(beanName = "ItemService")
    private ISalesService<Item> itemService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Item) value).toString();
        }
        return null;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        Item item = null;

        if (string != null && !"".equals(string)) {
            item = this.itemService.find(new Integer(string));
        }

        return item;
    }
}
