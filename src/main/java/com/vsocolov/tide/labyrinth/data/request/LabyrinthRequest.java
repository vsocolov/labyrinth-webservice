package com.vsocolov.tide.labyrinth.data.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class LabyrinthRequest implements Serializable {

    @NotEmpty
    @Size(min = 2, max = 2)
    private int[] startPoint;

    @NotEmpty
    private char[][] labirinth;

    public LabyrinthRequest() {
        super();
    }

    public LabyrinthRequest(int[] startPoint, char[][] labirinth) {
        this.startPoint = startPoint;
        this.labirinth = labirinth;
    }

    public int[] getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(final int[] startPoint) {
        this.startPoint = startPoint;
    }

    public char[][] getLabirinth() {
        return labirinth;
    }

    public void setLabirinth(final char[][] labirinth) {
        this.labirinth = labirinth;
    }
}
