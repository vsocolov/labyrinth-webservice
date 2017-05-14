package com.vsocolov.tide.labyrinth.data;


import com.vsocolov.tide.labyrinth.data.enums.Direction;

public final class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Point point = (Point) o;

        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public Point move(final Direction direction) {
        switch (direction) {
            case UP:
                return new Point(x - 1, y);
            case DOWN:
                return new Point(x + 1, y);
            case LEFT:
                return new Point(x, y - 1);
            default:
                return new Point(x, y + 1);
        }

    }

}
