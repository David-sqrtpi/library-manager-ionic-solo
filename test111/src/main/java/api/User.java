package api;

import entity.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class User {

    CloudFirestoreDatabase cloudFirestoreDatabase = new CloudFirestoreDatabase();

    @POST
    public Response createUser(String json){

        cloudFirestoreDatabase.saveUser(json);

        return Response.ok(json).build();

    }

    @GET
    @Path("/{email}")
    public Response getUser(@PathParam("email") String email) throws ExecutionException, InterruptedException {

        return Response.ok(cloudFirestoreDatabase.getUser(email)).build();

    }

    @PUT
    @Path("/{email}")
    public Response updateUser(@PathParam("email") String email,
                               @FormParam("nombre") String nombre,
                               @FormParam("apellido") String apellido,
                               @FormParam("password") String password,
                               @FormParam("edad") int edad,
                               @FormParam("rol") String rol) {

        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setContrasena(password);
        usuario.setEdad(edad);
        usuario.setRol(rol);



        return Response.ok().build();

    }

}
