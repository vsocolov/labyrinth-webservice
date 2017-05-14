package com.vsocolov.tide.labyrinth.facade.impl;

import com.vsocolov.tide.labyrinth.data.request.LabyrinthRequest;
import com.vsocolov.tide.labyrinth.data.response.LabyrinthResponse;
import com.vsocolov.tide.labyrinth.exception.NoEscapeException;
import com.vsocolov.tide.labyrinth.facade.LabyrinthFacade;
import com.vsocolov.tide.labyrinth.service.LabyrinthEscapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LabyrinthFacadeImpl implements LabyrinthFacade {

    @Autowired
    private LabyrinthEscapeService labyrinthEscapeService;

    @Override
    public LabyrinthResponse escapeLabyrinth(final LabyrinthRequest request) {
        final LabyrinthResponse response = new LabyrinthResponse();
        int startX = request.getStartPoint()[0];
        int startY = request.getStartPoint()[1];

        try {
            response.setLabyrinth(labyrinthEscapeService.drawPathForEscape(request.getLabirinth(), startX, startY));
        } catch (final NoEscapeException e) {
            response.setErrorMessage(NO_ESCAPE_ERROR_MESSAGE);
        }

        return response;
    }
}
