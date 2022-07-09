package org.hachiko.shopping.cart;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api/cart")
@ApplicationScoped
public class ShoppingCartResource {
    List<CartItem> items = new ArrayList<>();

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(){
        return Response.ok(items).build();
    }

    @POST
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItem(CartItem newItem){
        items.add(newItem);
        return Response.ok(items).build();
    }

    @Path("{id}")
    @RolesAllowed({"admin"})
    @DELETE
    public Response deleteItem(@PathParam("id") Long id){
        items.stream().filter(item -> item.getId().equals(id)).findFirst().ifPresent(item -> items.remove(item));
        return Response.noContent().build();
    }
}
