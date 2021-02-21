package io.aturanj.sales.model;

import java.io.Serializable;
import java.util.Objects;

public class InvoiceTreeNode implements Serializable, Comparable<InvoiceTreeNode> {

    private String id;

    private String customerName;

    private String total;

    public InvoiceTreeNode(String id, String customerName, String total) {
        this.id = id;
        this.customerName = customerName;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.customerName);
        hash = 19 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InvoiceTreeNode other = (InvoiceTreeNode) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(InvoiceTreeNode o) {
        return this.getId().compareTo(o.getId());
    }
}
