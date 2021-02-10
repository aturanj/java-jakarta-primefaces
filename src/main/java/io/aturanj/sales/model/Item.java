package io.aturanj.sales.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEM", schema = "SALES")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByInvoiceid", query = "SELECT i FROM Item i WHERE i.itemPK.invoiceid = :invoiceid"),
    @NamedQuery(name = "Item.findByItem", query = "SELECT i FROM Item i WHERE i.itemPK.item = :item"),
    @NamedQuery(name = "Item.findByQuantity", query = "SELECT i FROM Item i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "Item.findByCost", query = "SELECT i FROM Item i WHERE i.cost = :cost")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemPK itemPK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "COST")
    private BigDecimal cost;
    @JoinColumn(name = "INVOICEID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Invoice invoice;
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "ID")
    @ManyToOne
    private Product product;

    public Item() {
    }

    public Item(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public Item(int invoiceid, int item) {
        this.itemPK = new ItemPK(invoiceid, item);
    }

    public ItemPK getItemPK() {
        return itemPK;
    }

    public void setItemPK(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemPK != null ? itemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Item)) {
            return false;
        }

        Item other = (Item) object;

        return !((this.itemPK == null && other.itemPK != null) || (this.itemPK != null && !this.itemPK.equals(other.itemPK)));
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Product: ");
        sb.append(getProduct().getName()).append(" Quantity: ").append(getQuantity());

        return sb.toString();
    }
}
