package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = dest.y > source.y ? dest.y - source.y : source.y - dest.y;
        Cell[] steps = new Cell[size];
        int deltaX = dest.x - source.x < 0 ? -1 : 1;
        int deltaY = dest.y - source.y < 0 ? -1 : 1;
        int x = source.x;
        int y = source.y;
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }
    public boolean isDiagonal(Cell source, Cell dest) {
        int size = dest.y > source.y ? dest.y - source.y : source.y - dest.y;
        
        int deltaX = dest.x - source.x < 0 ? -1 : 1;
        int deltaY = dest.y - source.y < 0 ? -1 : 1;
        int x = source.x;
        int y = source.y;
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
