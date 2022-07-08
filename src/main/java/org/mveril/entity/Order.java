package org.mveril.entity;

import org.mveril.enumeration.OrderSate;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(columnDefinition = "INT")
    private int id;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Customer customer;
    private String typePresta;
    private String designation;
    private int nbDays;
    private float unitPrice;
    @Column(columnDefinition = "BIT")
    private OrderSate state;
    /*
    private float totalExcludeTaxe;
    private float totalWithTaxe;
     */

    public Order() {
    }

    public Order(Customer customer, String typePresta, String designation, int nbDays, float unitPrice, OrderSate state) {
        this.customer = customer;
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderSate getState() {
        return state;
    }

    public void setState(OrderSate state) {
        this.state = state;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", state=" + state +
                '}';
    }
}
