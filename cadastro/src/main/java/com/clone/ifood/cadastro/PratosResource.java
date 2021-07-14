package com.clone.ifood.cadastro;

import com.clone.ifood.cadastro.dto.AdicionarPratoDTO;
import com.clone.ifood.cadastro.dto.AtualizarPratoDTO;
import com.clone.ifood.cadastro.dto.PratoDTO;
import com.clone.ifood.cadastro.dto.PratoMapper;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Existe varios Pratos para cada restaurante
// Para documentação usado o path de restaurantes
@Path("/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "prato")
public class PratosResource {

    @Inject
    PratoMapper pratoMapper;

    @GET
    @Path("{idRestaurante}/pratos")
    public List<PratoDTO> listarPratos(@PathParam("idRestaurante") Long idRestaurante){
        Optional<Restaurante> restauranteOP = Restaurante.findByIdOptional(idRestaurante);

        if (restauranteOP.isEmpty()){
            throw new NotFoundException("Restaurante nao existe");
        }

        Stream<Prato> pratos = Prato.stream("restaurante", restauranteOP.get());
        return pratos
                .map(p -> pratoMapper.toPratoDTO(p))
                .collect(Collectors.toList());
    }


    @POST
    @Path("{idRestaurante}/pratos")
    @Transactional
    public Response adicionarPrato(@PathParam("idRestaurante") Long idRestaurante, AdicionarPratoDTO pratoDTO){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);

        if(restauranteOp.isEmpty()){
            throw new NotFoundException("Restaurante nao existe");
        }

        Prato prato = pratoMapper.toPrato(pratoDTO);
        prato.restaurante = restauranteOp.get();
        prato.persist();

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{idRestaurante}/pratos/{id}")
    @Transactional
    public void atualizaPrato(@PathParam("idRestaurante") Long idRestaurante, @PathParam("id") Long id, AtualizarPratoDTO pratoDTO){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);

        if(restauranteOp.isEmpty()){
            throw new NotFoundException("Restaurante nao existe");
        }

        // Regra solicitado pelo Curso da Udemy
        // Alteração somente deve do preco do prato
        Optional<Prato> pratoOp = Prato.findByIdOptional(id);

        if(pratoOp.isEmpty()){
            throw new NotFoundException("Prato nao existe");
        }

        Prato prato = pratoOp.get();
        pratoMapper.toPrato(pratoDTO, prato);

        prato.persist();
    }

    @DELETE
    @Path("{idRestaurante}/pratos/{id}")
    @Transactional
    public void remover(@PathParam("idRestaurante") Long idRestaurante, @PathParam("id") Long id){
        Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);

        if(restauranteOp.isEmpty()){
            throw new NotFoundException("Restaurante nao existe");
        }

        Optional<Prato> pratoOp = Prato.findByIdOptional(id);

        pratoOp.ifPresentOrElse(
                Prato::delete,
                () -> {
                    throw new NotFoundException();
                }
        );
    }
}
