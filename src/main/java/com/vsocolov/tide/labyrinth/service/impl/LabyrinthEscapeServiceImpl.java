package com.vsocolov.tide.labyrinth.service.impl;

import com.vsocolov.tide.labyrinth.data.Point;
import com.vsocolov.tide.labyrinth.exception.NoEscapeException;
import com.vsocolov.tide.labyrinth.service.LabyrinthEscapeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.vsocolov.tide.labyrinth.data.enums.Direction.*;

@Service
public class LabyrinthEscapeServiceImpl implements LabyrinthEscapeService {

    @Override
    public char[][] drawPathForEscape(char[][] labyrinth, int startX, int startY) throws NoEscapeException {
        if (!exploreLabyrinth(labyrinth, new Point(startX, startY), new HashSet<>())) {
            throw new NoEscapeException();
        }

        return labyrinth;
    }

    private boolean exploreLabyrinth(char[][] labyrinth, final Point point, final Set<Point> visitedPoints) {
        if (visitedPoints.contains(point) || labyrinth[point.getX()][point.getY()] == WALL)
            return false;

        if (foundExit(labyrinth, point))
            return true;

        visitedPoints.add(point);

        Point next = point.move(DOWN);
        if (exploreLabyrinth(labyrinth, next, visitedPoints)) {
            labyrinth[point.getX()][point.getY()] = PATH;
            return true;
        }
        markPath(labyrinth, next);

        next = point.move(UP);
        if (exploreLabyrinth(labyrinth, next, visitedPoints)) {
            labyrinth[point.getX()][point.getY()] = PATH;
            return true;
        }
        markPath(labyrinth, next);

        next = point.move(RIGHT);
        if (exploreLabyrinth(labyrinth, next, visitedPoints)) {
            labyrinth[point.getX()][point.getY()] = PATH;
            return true;
        }
        markPath(labyrinth, next);

        next = point.move(LEFT);
        if (exploreLabyrinth(labyrinth, next, visitedPoints)) {
            labyrinth[point.getX()][point.getY()] = PATH;
            return true;
        }
        markPath(labyrinth, next);

        return false;
    }

    private void markPath(char[][] labyrinth, Point next) {
        if (labyrinth[next.getX()][next.getY()] == PATH) {
            labyrinth[next.getX()][next.getY()] = FREE;
        }
    }

    private boolean foundExit(final char[][] labyrinth, final Point point) {
        int labyrinthWidth = labyrinth.length;
        int columnHeight = labyrinth[point.getX()].length;

        if (labyrinth[point.getX()][point.getY()] == FREE && ((point.getX() == labyrinthWidth - 1)
                || (point.getX() == 0) || (point.getY() == 0) || (point.getY() == columnHeight - 1))) {
            labyrinth[point.getX()][point.getY()] = PATH;
            return true;
        }

        return false;
    }
}

