package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Ignore
    @Test

    public void move() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }
    // Проверка метода position. Создайте объект и вызовите у него м,етод position. Проверьте, что он занимает ту же ячейку,
    // что и при создании объекта.

    @Test
    public void position() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell rsl = bishopBlack.position();
        assertThat(rsl, is(Cell.C1));
    }

    @Test
    //Проверка метода copy. Создайте объект и вызовите у него метод copy. Проверь,те, что, возвращенный объект имеет
    // правильную позицию.
    public void copy() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure rsl = bishopBlack.copy(Cell.H6);
        assertThat(rsl.position(), is(Cell.H6));
    }

    //Для этого создайте объект с начальным положеним C1. Вызовите метод way с указанием C1 и G5. Метод должен вернуть
    // массив из 4 клеток. D2, E3, F4, G5.
    @Test
    public void way() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.C1,Cell.G5);
        Cell[] expected= {Cell.D2,Cell.E3,Cell.F4,Cell.G5};
        assertThat(rsl, is(expected));
    }
}