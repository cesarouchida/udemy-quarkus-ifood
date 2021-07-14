package com.clone.ifood.cadastro;

import com.clone.ifood.cadastro.dto.AdicionarRestauranteDTO;
import com.clone.ifood.cadastro.dto.AtualizarRestauranteDTO;
import com.clone.ifood.cadastro.dto.RestauranteDTO;
import com.clone.ifood.cadastro.dto.RestauranteMapper;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "restaurante")
public class RestauranteResource {

    // Responsável pela Documentação REST
    @Inject
    RestauranteMapper restauranteMapper;

    @GET
    public List<RestauranteDTO> buscar(){
        Stream<Restaurante> restaurantes = Restaurante.streamAll();
        return restaurantes
                .map(r -> restauranteMapper.toRestauranteDTO(r))
                .collect(Collectors.toList());
    }

    @POST
    @Transactional
    public Response adicionar(@Valid AdicionarRestauranteDTO dto){
        Restaurante restaurante = restauranteMapper.toRestaurante(dto);
        restaurante.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void atualiza(@PathParam("id") Long id, AtualizarRestauranteDTO dto){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(id);

        if(restauranteOp.isEmpty()){
            throw new NotFoundException();
        }

        Restaurante restaurante = restauranteOp.get();

        restauranteMapper.toRestaurante(dto, restaurante);
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
