package cat.urv.deim.sob.service;

import cat.urv.deim.sob.model.Customer;
import jakarta.json.Json;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

public class CustomerService {

    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/SO-API_REST/rest/api/v1/";

    public CustomerService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("customer");
    }

    public Customer login(String username, String password) {
        WebTarget resource = webTarget.path("login");
        String login = Json.createObjectBuilder()
            .add("username", username)
            .add("password", password)
            .build()
            .toString();
        Response response = resource.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(login, MediaType.APPLICATION_JSON), Response.class);
        return (response.getStatus() == 200) ? response.readEntity(Customer.class) : null;
    }
    
    public Customer register(String username, String password, String name, String phone) {
        WebTarget resource = webTarget.path("register");
        String register;
        if (phone.isEmpty()) {
            register = Json.createObjectBuilder()
            .add("username", username)
            .add("password", password)
            .add("name", name)
            .build()
            .toString();
        } else {
            register = Json.createObjectBuilder()
            .add("username", username)
            .add("password", password)
            .add("name", name)
            .add("phone", phone)
            .build()
            .toString();
        }
        Response response = resource.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(register, MediaType.APPLICATION_JSON), Response.class);
        return (response.getStatus() == 200) ? response.readEntity(Customer.class) : null;
    }
}