
package cat.urv.deim.sob.model;

import cat.urv.deim.sob.model.Credentials;
import java.util.Collection;
import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;

    private String name;
    

    private String email;
    
    private Credentials password;
    
    private String phone;

    private Collection<Order> orders;
    
    
    public Customer() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
