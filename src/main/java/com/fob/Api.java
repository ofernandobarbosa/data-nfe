package com.fob;

import com.fob.entities.NFe;
import com.fob.services.SelecaoServico;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class Api {

    @Inject
    SelecaoServico selecaoServico;

    @GET
    @Path("/{chave}")
    @Produces(MediaType.APPLICATION_JSON)
    public NFe getNfe(@PathParam("chave") String chave) {

        return selecaoServico.selecionarServico(chave);

    }
}
