package de.c24.finacc.klt.rest;

import de.c24.finacc.klt.dto.RestResponseDTO;
import de.c24.finacc.klt.repository.RequestRepository;
import de.c24.finacc.klt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

/**
 * @author Jörn Schricker
 */
@Path("/")
@Produces("application/json")
public class RestService {

    /**
     * dependency for RequestRepository
     */
    @Qualifier("requestRepository")
    @Autowired
    private RequestRepository repository;

    /**
     * getRequests
     * @return all requests
     */
    @GET
    @Path("/requests")
    public RestResponseDTO getRequests() {
        return new RestResponseDTO(repository.getAll());
    }

    /**
     * validation for age
     * @return validation result of age
     */
    @GET
    @Path("/age/{age}")
    public RestResponseDTO validateAge(@PathParam("age") int age) {
            if (age < 18) {
                return new RestResponseDTO("too young", 1, null);
            } else if (age > 67) {
                return new RestResponseDTO("too old", 2, null);
            } else if (MathUtil.isPrime(age)) {
                return new RestResponseDTO("funny");
            }
            return new RestResponseDTO("OK");
    }

    /**
     * delete request
     * @return delete request result
     */
    @DELETE
    @Path("/requests/{id}")
    public RestResponseDTO getRequests(@PathParam("id") int id) {
        repository.delete(id);
        return new RestResponseDTO("successfully deleted");
    }

}
