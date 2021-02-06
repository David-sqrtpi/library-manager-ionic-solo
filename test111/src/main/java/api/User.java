package api;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.concurrent.ExecutionException;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class User {

    DatabaseService cloudFirestoreDatabase = new CloudFirestoreDatabase();

    @POST
    public Response createUser(String json) {

        cloudFirestoreDatabase.saveUser(json);

        return Response.ok(json).build();

    }

    @GET
    @Path("/{email}")
    public Response getUser(@PathParam("email") String email) throws ExecutionException, InterruptedException {

        return Response.ok(cloudFirestoreDatabase.getUser(email)).build();

    }

}
