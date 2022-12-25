package cat.urv.deim.sob.service;

import cat.urv.deim.sob.model.User;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Entity;
        
public class UserService {
    private WebTarget webTarget;
    private jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/SO-API_REST/rest/api/v1/";
    
    public UserService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }
    
    public Boolean checkAuthentication(String username, String password){
        
        Response response = webTarget.path("credentials").path(username).path(password)
                .request(MediaType.APPLICATION_JSON)
                .get();
       
        return (response.getStatus() == 200) ? true : false;
    }
	

}
