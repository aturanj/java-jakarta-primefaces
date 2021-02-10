package io.aturanj.sales.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "INVOICEID")
    private int invoiceid;
    @Basic(optional = false)
    @Column(name = "ITEM")
    private int item;

    public ItemPK() {
    }

    public ItemPK(int invoiceid, int item) {
        this.invoiceid = invoiceid;
        this.item = item;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) invoiceid;
        hash += (int) item;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ItemPK)) {
            return false;
        }
        ItemPK other = (ItemPK) object;
        if (this.invoiceid != other.invoiceid) {
            return false;
        }
        return this.item == other.item;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Invoce: ");
        sb.append(getInvoiceid()).append(" Item: ").append(getItem());

        return sb.toString();
    }
}
