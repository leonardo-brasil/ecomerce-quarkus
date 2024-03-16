package br.unitins.loja.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.unitins.loja.DTO.UsuarioRequestDTO;
import br.unitins.loja.service.UsuarioService;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    public UsuarioService usuarioService;

    @GET
    public Response read() {

        return Response.ok(usuarioService.read()).build();

    }

    @POST
    public Response create(@Valid UsuarioRequestDTO dto) {

        return Response.status(Status.CREATED).entity(usuarioService.create(dto)).build();

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid UsuarioRequestDTO dto) {
        usuarioService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {

        usuarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
        
    }

}
