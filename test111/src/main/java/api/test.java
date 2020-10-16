package api;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class test {

    @POST
    public Response createAdmin(String json) {

        System.out.println(json);

        CloudFirestoreDatabase cloudFirestoreDatabase = new CloudFirestoreDatabase();

        cloudFirestoreDatabase.test(json);

        return Response.ok().build();

    }

}
