package com.clone.ifood.cadastro;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "restaurante")
public class RestauranteResource {

    @GET
    public List<Restaurante> hello(){
        return Restaurante.listAll();
    }

    @POST
    @Transactional
    public Response adicionar(Restaurante dto){
        dto.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void atualiza(@PathParam("id") Long id, Restaurante dto){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(id);

        if(restauranteOp.isEmpty()){
            throw new NotFoundException();
        }

        Restaurante restaurante = restauranteOp.get();

        restaurante.nome = dto.nome;
        restaurante.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void remove(@PathParam("id") Long id){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(id);

        restauranteOp.ifPresentOrElse(
                Restaurante::delete,
                () -> {
                    throw new NotFoundException();
                }
        );

    }
}
