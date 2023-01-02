package cat.urv.deim.sob.model;

import java.util.Date;

public class Order {
    private int id;

    private Date datePurchase;
    
    private float amount;
    
    private float euros;
    
    private Customer customer;
    
    private Cryptocurrency cryptocurrency;
    
    
    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getEuros() {
        return euros;
    }

    public void setEuros(float euros) {
        this.euros = euros;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cryptocurrency getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(Cryptocurrency cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }
    
}
