package com.bnppf.kata;

import com.bnppf.kata.exception.InvalidMoveException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TicTacToeGameTest {

    private static final int GRID_ONE = 1;

    private static final int GRID_TWO = 2;

    private static final int GIRD_ZERO = 0;

    private static final int INVALID_ROW_OR_COLUMN_NUMBER_NEGATIVE_ONE = -1;

    private static final int INVALID_ROW_OR_COLUMN_NUMBER_THREE = 3;

    private static final int ONE_CELL_FILLED = 1;

    private static final int TWO_CELLS_FILLED = 2;

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
    public void checkIfXIsMarkedAtRowZeroColumnZeroIfPlayerXPlaysAtRowZeroColumnZeroInGameBoard() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markPlayerAtRowColumnInGameBoard(FIRST_PLAYER, GIRD_ZERO, GIRD_ZERO);

        assertEquals(FIRST_PLAYER, TIC_TAC_TOE_GAME.getTicTacToeGameBoard(GIRD_ZERO, GIRD_ZERO));

    }

    @Test
    public void checkIfOIsMarkedAtRowZeroColumnOneIfPlayerOPlaysAtRowZeroColumnOneInGameBoard() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markPlayerAtRowColumnInGameBoard(SECOND_PLAYER, GIRD_ZERO, GRID_ONE);

        assertEquals(SECOND_PLAYER, TIC_TAC_TOE_GAME.getTicTacToeGameBoard(GIRD_ZERO, GRID_ONE));

    }

    @Test
    public void checkIfNumberOfCellsFilledIsOneForOneMoveByAPlayer() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markPlayerAtRowColumnInGameBoard(FIRST_PLAYER, GIRD_ZERO, GIRD_ZERO);

        assertEquals(ONE_CELL_FILLED, TIC_TAC_TOE_GAME.getNumberOfCellsFilled());

    }

    @Test
    public void checkIfNumberOfCellsFilledIsTwoForOneMoveEachByBothPlayers() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markPlayerAtRowColumnInGameBoard(FIRST_PLAYER, GIRD_ZERO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markPlayerAtRowColumnInGameBoard(SECOND_PLAYER, GIRD_ZERO, GRID_ONE);

        assertEquals(TWO_CELLS_FILLED, TIC_TAC_TOE_GAME.getNumberOfCellsFilled());

    }

    @Test
    public void checkIfCurrentPlayerIsXBeforeFirstMove() {

        assertEquals(FIRST_PLAYER, TIC_TAC_TOE_GAME.getCurrentPlayer());

    }

    @Test
    public void checkIfCurrentPlayerIsOAfterFirstMove() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markPlayerAtRowColumnInGameBoard(FIRST_PLAYER, GIRD_ZERO, GIRD_ZERO);

        assertEquals(SECOND_PLAYER, TIC_TAC_TOE_GAME.getCurrentPlayer());

    }

    @Test
    public void checkIfTheBoardReturnsXFromTheRowZeroColumnZeroInWhichTheFirstMoveIsMade() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GIRD_ZERO);

        assertEquals(FIRST_PLAYER, TIC_TAC_TOE_GAME.getTicTacToeGameBoard(GIRD_ZERO, GIRD_ZERO));

    }
    @Test
    public void checkIfTheBoardReturnsOFromTheRowZeroColumnOneInWhichTheSecondMoveIsMade() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GRID_ONE);

        assertEquals(SECOND_PLAYER, TIC_TAC_TOE_GAME.getTicTacToeGameBoard(GIRD_ZERO, GRID_ONE));

    }

    @Test(expected = InvalidMoveException.class)
    public void checkIfExceptionIsThrownIfInputRowIsGreaterThanTwo() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(INVALID_ROW_OR_COLUMN_NUMBER_THREE, GIRD_ZERO);

    }

    @Test(expected = InvalidMoveException.class)
    public void checkIfExceptionIsThrownIfInputRowIsLessThanZero() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(INVALID_ROW_OR_COLUMN_NUMBER_NEGATIVE_ONE, GIRD_ZERO);

    }

    @Test(expected = InvalidMoveException.class)
    public void checkIfExceptionIsThrownIfInputColumnIsGreaterThanTwo() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, INVALID_ROW_OR_COLUMN_NUMBER_THREE);

    }

    @Test(expected = InvalidMoveException.class)
    public void checkIfExceptionIsThrownIfInputColumnIsLessThanZero() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, INVALID_ROW_OR_COLUMN_NUMBER_NEGATIVE_ONE);

    }

    @Test(expected = InvalidMoveException.class)
    public void checkIfExceptionIsThrownIfSamePositionIsPlayedTwice() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GIRD_ZERO);

    }

    @Test
    public void checkIfXIsReturnedIfXFillsThreeSquaresInFirstRow() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_ONE, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GRID_ONE);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_TWO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GRID_TWO);

        assertEquals(FIRST_PLAYER, TIC_TAC_TOE_GAME.checkForWinnerInTheGame());

    }

    @Test
    public void checkIfXIsReturnedIfXFillsThreeSquaresInSecondRow() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_ONE, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_ONE, GRID_ONE);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_TWO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_ONE, GRID_TWO);

        assertEquals(FIRST_PLAYER, TIC_TAC_TOE_GAME.checkForWinnerInTheGame());

    }

    @Test
    public void checkIfXIsReturnedIfXFillsThreeSquaresInThirdRow() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_TWO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_TWO, GRID_ONE);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_ONE, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_TWO, GRID_TWO);

        assertEquals(FIRST_PLAYER, TIC_TAC_TOE_GAME.checkForWinnerInTheGame());

    }

    @Test
    public void checkIfOIsReturnedIfOFillsThreeSquaresInFirstColumn() throws InvalidMoveException {

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_ONE, GRID_ONE);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GRID_ONE);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_ONE, GIRD_ZERO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GIRD_ZERO, GRID_TWO);

        TIC_TAC_TOE_GAME.markCurrentPlayerAtRowColumnInGameBoard(GRID_TWO, GIRD_ZERO);

        assertEquals(SECOND_PLAYER, TIC_TAC_TOE_GAME.checkForWinnerInTheGame());

    }

}
