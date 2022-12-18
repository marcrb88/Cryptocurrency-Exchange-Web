package cat.urv.deim.sob.model;

import java.util.Date;

public class Cryptocurrency  {

    private int id;

    private String name;
    
    private String description;

    private float lastQuote;
    
    private Date lastQuoteTime;
 
    public Cryptocurrency() {}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getLastQuote() {
        return lastQuote;
    }

    public void setLastQuote(float lastQuote) {
        this.lastQuote = lastQuote;
    }

    public Date getLastQuoteTime() {
        return lastQuoteTime;
    }

    public void setLastQuoteTime(Date lastQuoteTime) {
        this.lastQuoteTime = lastQuoteTime;
    }

}
