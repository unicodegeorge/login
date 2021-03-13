package cz.unicode.george.resources;

import cz.unicode.george.entities.UserEntity;
import cz.unicode.george.managers.UserManager;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("user")
public class UserResource {
    @Inject
    UserManager userManager;
    @POST
    @Path("register")
    public Response register(UserEntity user) {
        if(userManager.registerUser(user)){
            return Response.ok(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    public Response getAllUsers() {
        return Response.ok(userManager.getAllUsers()).build();
    }
}
