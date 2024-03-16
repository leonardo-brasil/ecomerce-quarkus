package br.unitins.loja.resource;

import br.unitins.loja.DTO.CompraRequestDTO;
import br.unitins.loja.service.CompraService;
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

@Path("/compra")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResource {

    @Inject
    public CompraService compraService;

    @GET
    public Response read() {
        return Response.ok(compraService.read()).build();
    }

    @POST
    public Response create(@Valid CompraRequestDTO dto) {

        return Response.status(Status.CREATED).entity(compraService.create(dto)).build();

    }

    @PUT
    @Path(value = "/{id}")
    public Response update(@PathParam("id") Long id, @Valid CompraRequestDTO dto) {
        compraService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        compraService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
