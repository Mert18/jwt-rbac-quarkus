package org.hachiko.shopping.jwt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jwt")
@ApplicationScoped
public class JwtResource {

    @Inject
    JwtService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJwt(){
        String jwt = service.generateJwt();
        return Response.ok(jwt).build();
    }
}

