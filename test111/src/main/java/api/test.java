package api;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.concurrent.ExecutionException;

@Path("/validation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class test {

    @POST
    public Response validator(String emailJson) throws ExecutionException, InterruptedException {

        CloudFirestoreDatabase cloudFirestoreDatabase = new CloudFirestoreDatabase();

        System.out.println(emailJson);

        if (cloudFirestoreDatabase.validation(emailJson)) {
            return Response.ok().build();
        } else {

            return Response.ok("\"error\"").build();

        }

    }

}
