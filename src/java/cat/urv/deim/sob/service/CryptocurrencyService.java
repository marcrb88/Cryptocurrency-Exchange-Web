package cat.urv.deim.sob.service;

import cat.urv.deim.sob.model.Cryptocurrency;
import cat.urv.deim.sob.model.Order;
import cat.urv.deim.sob.model.User;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.GenericType;
import java.util.List;
        
public class CryptocurrencyService {
    private WebTarget webTarget;
    private jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/SO-API_REST/rest/api/v1/";

    public CryptocurrencyService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cryptocurrency");
    }
    
    public List<Cryptocurrency> findAll(String order) {
       WebTarget resource = webTarget.queryParam("order",order);
       Response response = resource.request(MediaType.APPLICATION_JSON).get();
        
       return (response.getStatus() == 200) ? response.readEntity(new GenericType<List<Cryptocurrency>>() {}) : null;
                
    }
    
    public Order getOrder(String id){
        WebTarget resource = webTarget.path(id).path("order");
        Response response = resource.request(MediaType.APPLICATION_JSON).get();
        response.getStatus();
        return (response.getStatus() == 200) ? response.readEntity(Order.class) : null;
    }
    
     public Cryptocurrency getCryptocurrency(String id){
        WebTarget resource = webTarget.path(id);
        Response response = resource.request(MediaType.APPLICATION_JSON).get();
        response.getStatus();
        return (response.getStatus() == 200) ? response.readEntity(Cryptocurrency.class) : null;
    }
	

}
