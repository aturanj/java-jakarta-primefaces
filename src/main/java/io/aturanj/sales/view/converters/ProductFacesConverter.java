package io.aturanj.sales.view.converters;

import io.aturanj.sales.model.Product;
import io.aturanj.sales.service.ISalesService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Product.class)
public class ProductFacesConverter implements Converter {

    @EJB(beanName = "ProductService")
    private ISalesService<Product> productService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Product) value).toString();
        }
        return null;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        Product product = null;

        if (string != null && !"".equals(string)) {
            product = this.productService.find(new Integer(string));
        }

        return product;
    }
}
