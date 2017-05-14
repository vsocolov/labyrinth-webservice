package com.vsocolov.tide.labyrinth.facade;

import com.vsocolov.tide.labyrinth.data.request.LabyrinthRequest;
import com.vsocolov.tide.labyrinth.data.response.LabyrinthResponse;

public interface LabyrinthFacade {
    String NO_ESCAPE_ERROR_MESSAGE = "No escape paths exist!";

    LabyrinthResponse escapeLabyrinth(LabyrinthRequest request);
}
