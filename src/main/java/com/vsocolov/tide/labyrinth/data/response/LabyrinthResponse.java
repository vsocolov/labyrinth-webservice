package com.vsocolov.tide.labyrinth.data.response;

import java.io.Serializable;

public class LabyrinthResponse implements Serializable {

    private char[][] labyrinth;

    private String errorMessage;

    public char[][] getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(final char[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
