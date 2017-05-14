package com.vsocolov.tide.labyrinth.api.resource;

import com.vsocolov.tide.labyrinth.api.PathConstants.Resources;
import com.vsocolov.tide.labyrinth.data.request.LabyrinthRequest;
import com.vsocolov.tide.labyrinth.data.response.LabyrinthResponse;
import com.vsocolov.tide.labyrinth.facade.LabyrinthFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path(value = Resources.ESCAPE)
public class LabyrinthResource {

    @Autowired
    private LabyrinthFacade labyrinthFacade;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LabyrinthResponse escapeLabyrinth(@Valid LabyrinthRequest request) {
        return labyrinthFacade.escapeLabyrinth(request);
    }
}
