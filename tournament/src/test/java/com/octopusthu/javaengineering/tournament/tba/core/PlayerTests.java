package com.octopusthu.javaengineering.tournament.tba.core;

import com.octopusthu.javaengineering.tournament.core.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTests {

    @Test
    void whenIdIsNullThenException() {
        assertThrows(Exception.class, () -> new Player(null, "张三"));
    }

    @Test
    void whenNameIsNullThenException() {
        assertThrows(Exception.class, () -> new Player(1, null));
    }

    @Test
    void whenNameIsEmptyThenException() {
        assertThrows(Exception.class, () -> new Player(1, ""));
    }

    @Test
    void whenNameIsBlankThenException() {
        assertThrows(Exception.class, () -> new Player(1, " "));
    }
}
