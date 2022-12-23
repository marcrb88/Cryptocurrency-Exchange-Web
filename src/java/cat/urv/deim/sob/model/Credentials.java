
package cat.urv.deim.sob.model;
        
import java.io.Serializable;


public class Credentials implements Serializable { 
   
    private Long id;
   
    private String password;
    
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}