package com.vsocolov.tide.labyrinth.service;


import com.vsocolov.tide.labyrinth.exception.NoEscapeException;

public interface LabyrinthEscapeService {

    char WALL = 'O';
    char FREE = ' ';
    char PATH = '•';

    /**
     * @param labyrinth A labyrinth drawn on a matrix of characters. It's at least 4x4, can be a rectangle or a square.
     *                  Walkable areas are represented with a space character, walls are represented with a big O character.
     *                  The escape point is always on the border (see README)
     * @param startX    Starting row number for the escape. 0 based.
     * @param startY    Starting column number for the escape. 0 based.
     * @return A char matrix with the same labyrinth and a path drawn from the starting point to the escape
     * @throws NoEscapeException when no path exists to the outside, from the selected starting point
     */
    char[][] drawPathForEscape(char[][] labyrinth, int startX, int startY) throws NoEscapeException;
}
