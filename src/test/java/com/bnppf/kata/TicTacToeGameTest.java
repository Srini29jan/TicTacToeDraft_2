package com.bnppf.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TicTacToeGameTest {

    @Test
    public void checkIfTicTacToeGameObjectIsNotNull() {

        assertNotNull(new TicTacToeGame());

    }

    @Test
    public void checkIfTicTacToeGameBoardPositionZeroZeroIsInitializedToNullCharacter() {

        assertEquals('\0', new TicTacToeGame().getTicTacToeGameBoard(0, 0));

    }
}
