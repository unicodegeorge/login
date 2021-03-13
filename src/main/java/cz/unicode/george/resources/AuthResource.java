package cz.unicode.george.resources;

import cz.unicode.george.entities.UserEntity;
import cz.unicode.george.managers.AuthManager;
import jdk.net.SocketFlow;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("auth")
public class AuthResource {
    @Inject
    AuthManager authmanager;


    @POST
    @Path("login")
    public Response login(UserEntity user) {
        if (authmanager.loginUser(user)) {
            return Response.ok(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("logout")
    public Response logout() {
        authmanager.logOf();
        return Response.ok(Response.Status.OK).build();
    }

    @GET
    public Response isUserLogged() {
        if (authmanager.isUserLogged()) {
            return Response.ok(authmanager.getLoggedUser()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
