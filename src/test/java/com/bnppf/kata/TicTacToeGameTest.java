package com.bnppf.kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TicTacToeGameTest {

    private static final int GRID_ONE = 1;

    private static final int GIRD_ZERO = 0;

    private static final char FIRST_PLAYER = 'X';

    private static final char INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD = '\0';

    private static final char SECOND_PLAYER = 'O';

    private TicTacToeGame TIC_TAC_TOE_GAME;

    @Before
    public void initializeTicTacToeGameObject() {

        TIC_TAC_TOE_GAME = new TicTacToeGame();

    }

    @Test
    public void checkIfTicTacToeGameObjectIsNotNull() {

        assertNotNull(TIC_TAC_TOE_GAME);

    }

    @Test
    public void checkIfTicTacToeGameBoardPositionZeroZeroIsInitializedToNullCharacter() {

        assertEquals(INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD, TIC_TAC_TOE_GAME.getTicTacToeGameBoard(GIRD_ZERO, GIRD_ZERO));

    }

    @Test
    public void checkIfXIsMarkedAtRowZeroColumnZeroIfPlayerXPlaysAtRowZeroColumnZeroInGameBoard() {

        TIC_TAC_TOE_GAME.markPlayerAtRowColumnInGameBoard(FIRST_PLAYER, GIRD_ZERO, GIRD_ZERO);

        assertEquals(FIRST_PLAYER, TIC_TAC_TOE_GAME.getTicTacToeGameBoard(GIRD_ZERO, GIRD_ZERO));

    }

    @Test
    public void checkIfOIsMarkedAtRowZeroColumnOneIfPlayerOPlaysAtRowZeroColumnOneInGameBoard() {

        TIC_TAC_TOE_GAME.markPlayerAtRowColumnInGameBoard(SECOND_PLAYER, GIRD_ZERO, GRID_ONE);

        assertEquals(SECOND_PLAYER, TIC_TAC_TOE_GAME.getTicTacToeGameBoard(GIRD_ZERO, GRID_ONE));

    }

    @Test
    public void checkIfNumberOfCellsFilledIsOneForOneMoveByAPlayer() {

        TIC_TAC_TOE_GAME.markPlayerAtRowColumnInGameBoard(FIRST_PLAYER, GIRD_ZERO, GIRD_ZERO);

        assertEquals(1, TIC_TAC_TOE_GAME.getNumberOfCellsFilled());

    }

}
