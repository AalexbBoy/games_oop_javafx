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
        int size = (dest.y-source.y);
        Cell[] steps = new Cell[size>0?size:-size];
        int deltaX = dest.x-source.x?1:-1;
        int deltaY = dest.x-source.x?1:-1;
        int x=0;
        int y=0;
        for (int index = 0; index < size; index++) {
            steps[index] =Cell.FindBy(index+deltaX,index+deltaY);
        }
        return steps;
        /*throw new IllegalStateException(
                String.format("Could not way by diagonal from %s to %s", source, dest)
        );*/
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
