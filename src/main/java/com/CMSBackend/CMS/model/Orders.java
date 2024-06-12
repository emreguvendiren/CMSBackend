package com.CMSBackend.CMS.model;

import com.CMSBackend.CMS.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private Table table;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    private double totalPrice;

    private int quantity;

    private OrderStatus status;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
