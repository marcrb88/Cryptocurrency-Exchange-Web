package cat.urv.deim.sob.service;

import cat.urv.deim.sob.model.Order;
import jakarta.json.Json;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.HttpHeaders;

public class OrderService {

    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/SO-API_REST/rest/api/v1/";

    public OrderService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("order");
    }

    public Order createOrder(String cryptoId, String amount, String credentials) {
        WebTarget resource = webTarget.queryParam("cryptocurrency", cryptoId);
        String order = Json.createObjectBuilder()
            .add("amount", amount)
            .build()
            .toString();
        Response response = resource.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Basic " + credentials)
                .post(Entity.entity(order, MediaType.APPLICATION_JSON), Response.class);
        return (response.getStatus() == 201) ? response.readEntity(Order.class) : null;
    }
    
    public Order findOrder(String id, String credentials) {
        WebTarget resource = webTarget.path(id);
        Response response = resource.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Basic " + credentials).get();
        return (response.getStatus() == 200) ? response.readEntity(Order.class) : null;
    }
}