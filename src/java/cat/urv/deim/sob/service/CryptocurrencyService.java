package cat.urv.deim.sob.service;

import cat.urv.deim.sob.model.Cryptocurrency;
import cat.urv.deim.sob.model.Order;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class CryptocurrencyService {

    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/SO-API_REST/rest/api/v1/";

    public CryptocurrencyService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cryptocurrency");
    }

    public List<Cryptocurrency> findAll(String order) {
        WebTarget resource = webTarget.queryParam("order", order);
        Response response = resource.request(MediaType.APPLICATION_JSON).get();
        return (response.getStatus() == 200) ? response.readEntity(new GenericType<List<Cryptocurrency>>() {
        }) : null;
    }

    public List<Order> findOrders(String id) {
        WebTarget resource = webTarget.path(id).path("order");
        Response response = resource.request(MediaType.APPLICATION_JSON).get();
        return (response.getStatus() == 200) ? response.readEntity(new GenericType<List<Order>>() {
        }) : null;
    }

    public Cryptocurrency findCryptocurrency(String id) {
        WebTarget resource = webTarget.path(id);
        Response response = resource.request(MediaType.APPLICATION_JSON).get();
        return (response.getStatus() == 200) ? response.readEntity(Cryptocurrency.class) : null;
    }
}
