package cat.urv.deim.sob.model;
import cat.urv.deim.sob.model.Customer;


import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private Date datePurchase;
    
    private float amount;
    
    private float euros;
    
    private Customer customer;
    
    private Cryptocurrency cryptocurrency;
    
    
    public Order() {}

    public Order(int id, Date datePurchase, float amount, Customer customer, Cryptocurrency cryptocurrency) {
        this.id = id;
        this.datePurchase = datePurchase;
        this.amount = amount;
        this.customer = customer;
        this.cryptocurrency = cryptocurrency;
    }

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
