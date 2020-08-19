package com.bnppf.kata;

import com.bnppf.kata.exception.InvalidMoveException;

public class TicTacToeGame {
    private static final int GRID_ONE = 1;
    private static final int GRID_TWO = 2;
    private static final int GRID_ZERO = 0;
    private static final int LOWER_LIMIT_OF_ROW_AND_COLUMN = 0;
    private static final int MINIMUM_NUMBER_OF_CELLS_REQUIRED_TO_BE_FILLED_TO_DECIDE_WINNER = 5;
    private static final int NUMBER_OF_GRIDS_IN_GAME_BOARD = 3;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_ZERO = 0;
    private static final int TOTAL_NUMBER_OF_CELLS_IN_GAME_BOARD = 9;
    private static final int UPPER_LIMIT_OF_ROW_AND_COLUMN = 2;
    private static final char CHARACTER_NULL = '\0';
    private static final char CHARACTER_REPRESENTING_GAME_DRAWN = 'D';
    private static final char FIRST_PLAYER = 'X';
    private static final char INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD = '\0';
    private static final char SECOND_PLAYER = 'O';
    private static final String MESSAGE_FOR_ALREADY_OCCUPIED_POSITION = "The position selected is already occupied. Please select an unoccupied position in the board";
    private static final String MESSAGE_FOR_INVALID_POSITION = "The position selected is invalid. Please select a number from 0, 1 or 2";
    private char[][] ticTacToeGameBoard;
    private int numberOfCellsFilled;

    public TicTacToeGame() {
        ticTacToeGameBoard = new char[NUMBER_OF_GRIDS_IN_GAME_BOARD][NUMBER_OF_GRIDS_IN_GAME_BOARD];
    }

    public char getTicTacToeGameBoard(int row, int column) {
        return ticTacToeGameBoard[row][column];
    }

    public void markPlayerAtRowColumnInGameBoard(char player, int row, int column) throws InvalidMoveException {
        if(isRowAndColumnWithinUpperAndLowerLimit(row, column)) {
            if(isPositionNotAlreadyOccupiedInGameBoard(row, column)) {
                ticTacToeGameBoard[row][column] = player;
                numberOfCellsFilled++;
            } else {
                throw new InvalidMoveException(MESSAGE_FOR_ALREADY_OCCUPIED_POSITION);
            }
        } else {
            throw new InvalidMoveException(MESSAGE_FOR_INVALID_POSITION);
        }
    }

    private boolean isPositionNotAlreadyOccupiedInGameBoard(int row, int column) {
        return getTicTacToeGameBoard(row, column) == INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD;
    }

    private boolean isRowAndColumnWithinUpperAndLowerLimit(int row, int column) {
        return row >= LOWER_LIMIT_OF_ROW_AND_COLUMN && row <= UPPER_LIMIT_OF_ROW_AND_COLUMN && column >= LOWER_LIMIT_OF_ROW_AND_COLUMN && column <= UPPER_LIMIT_OF_ROW_AND_COLUMN;
    }

    public void markCurrentPlayerAtRowColumnInGameBoard(int row, int column) throws InvalidMoveException {
        markPlayerAtRowColumnInGameBoard(getCurrentPlayer(), row, column);
    }

    public int getNumberOfCellsFilled() {
        return numberOfCellsFilled;
    }

    public char getCurrentPlayer() {
        return numberOfCellsFilled % NUMBER_TWO == NUMBER_ZERO ? FIRST_PLAYER : SECOND_PLAYER;
    }

    public char checkForWinnerInTheGame() {
        char winner = CHARACTER_NULL;
        if(numberOfCellsFilled >= MINIMUM_NUMBER_OF_CELLS_REQUIRED_TO_BE_FILLED_TO_DECIDE_WINNER) {
            winner = returnWinnerForStrikeInAnyRow();
            if (winner == CHARACTER_NULL) {
                winner = returnWinnerForStrikeInAnyColumn();
            }
            if (winner == CHARACTER_NULL) {
                winner = returnWinnerForStrikeInAnyDiagonal();
            }
            if (winner == CHARACTER_NULL && numberOfCellsFilled == TOTAL_NUMBER_OF_CELLS_IN_GAME_BOARD) {
                winner = CHARACTER_REPRESENTING_GAME_DRAWN;
            }
        }
        return winner;
    }

    private char returnWinnerForStrikeInAnyRow() {
        char valueAtFirstCellInFirstRow = getTicTacToeGameBoard(GRID_ZERO, GRID_ZERO);
        char valueAtSecondCellInFirstRow = getTicTacToeGameBoard(GRID_ZERO, GRID_ONE);
        char valueAtThirdCellInFirstRow = getTicTacToeGameBoard(GRID_ZERO, GRID_TWO);
        if (valueAtFirstCellInFirstRow != INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD && valueAtFirstCellInFirstRow == valueAtSecondCellInFirstRow && valueAtSecondCellInFirstRow == valueAtThirdCellInFirstRow) {
            return valueAtFirstCellInFirstRow;
        } else {
            char valueAtFirstCellInSecondRow = getTicTacToeGameBoard(GRID_ONE, GRID_ZERO);
            char valueAtSecondCellInSecondRow = getTicTacToeGameBoard(GRID_ONE, GRID_ONE);
            char valueAtThirdCellInSecondRow = getTicTacToeGameBoard(GRID_ONE, GRID_TWO);
            if (valueAtFirstCellInSecondRow != INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD && valueAtFirstCellInSecondRow == valueAtSecondCellInSecondRow && valueAtSecondCellInSecondRow == valueAtThirdCellInSecondRow) {
                return valueAtFirstCellInSecondRow;
            } else {
                char valueAtFirstCellInThirdRow = getTicTacToeGameBoard(GRID_TWO, GRID_ZERO);
                char valueAtSecondCellInThirdRow = getTicTacToeGameBoard(GRID_TWO, GRID_ONE);
                char valueAtThirdCellInThirdRow = getTicTacToeGameBoard(GRID_TWO, GRID_TWO);
                if (valueAtFirstCellInThirdRow != INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD && valueAtFirstCellInThirdRow == valueAtSecondCellInThirdRow && valueAtSecondCellInThirdRow == valueAtThirdCellInThirdRow) {
                    return valueAtFirstCellInThirdRow;
                }
            }
        }
        return CHARACTER_NULL;
    }

    private char returnWinnerForStrikeInAnyColumn() {
        char valueAtFirstCellInFirstColumn = getTicTacToeGameBoard(GRID_ZERO, GRID_ZERO);
        char valueAtSecondCellInFirstColumn = getTicTacToeGameBoard(GRID_ONE, GRID_ZERO);
        char valueAtThirdCellInFirstColumn = getTicTacToeGameBoard(GRID_TWO, GRID_ZERO);
        if(valueAtFirstCellInFirstColumn != CHARACTER_NULL && valueAtFirstCellInFirstColumn == valueAtSecondCellInFirstColumn && valueAtSecondCellInFirstColumn == valueAtThirdCellInFirstColumn) {
            return valueAtFirstCellInFirstColumn;
        } else {
            char valueAtFirstCellInSecondColumn = getTicTacToeGameBoard(GRID_ZERO, GRID_ONE);
            char valueAtSecondCellInSecondColumn = getTicTacToeGameBoard(GRID_ONE, GRID_ONE);
            char valueAtThirdCellInSecondColumn = getTicTacToeGameBoard(GRID_TWO, GRID_ONE);
            if(valueAtFirstCellInSecondColumn != CHARACTER_NULL && valueAtFirstCellInSecondColumn == valueAtSecondCellInSecondColumn && valueAtSecondCellInSecondColumn == valueAtThirdCellInSecondColumn) {
                return valueAtFirstCellInSecondColumn;
            } else {
                char valueAtFirstCellInThirdColumn = getTicTacToeGameBoard(GRID_ZERO, GRID_TWO);
                char valueAtSecondCellInThirdColumn = getTicTacToeGameBoard(GRID_ONE, GRID_TWO);
                char valueAtThirdCellInThirdColumn = getTicTacToeGameBoard(GRID_TWO, GRID_TWO);
                if(valueAtFirstCellInThirdColumn != CHARACTER_NULL && valueAtFirstCellInThirdColumn == valueAtSecondCellInThirdColumn && valueAtSecondCellInThirdColumn == valueAtThirdCellInThirdColumn) {
                    return valueAtFirstCellInThirdColumn;
                }
            }
        }
        return CHARACTER_NULL;
    }

    private char returnWinnerForStrikeInAnyDiagonal() {
        char valueAtTopLeftCell = getTicTacToeGameBoard(GRID_ZERO, GRID_ZERO);
        char valueAtMiddleCell = getTicTacToeGameBoard(GRID_ONE, GRID_ONE);
        char valueAtBottomRightCell = getTicTacToeGameBoard(GRID_TWO, GRID_TWO);
        if(valueAtTopLeftCell != INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD && valueAtTopLeftCell == valueAtMiddleCell && valueAtTopLeftCell == valueAtBottomRightCell) {
            return valueAtTopLeftCell;
        } else {
            char valueAtTopRightCell = getTicTacToeGameBoard(GRID_ZERO, GRID_TWO);
            char valueAtBottomLeftCell = getTicTacToeGameBoard(GRID_TWO, GRID_ZERO);
            if (valueAtTopRightCell != INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD && valueAtTopRightCell == valueAtMiddleCell && valueAtTopRightCell == valueAtBottomLeftCell) {
                return valueAtTopRightCell;
            }
        }
        return CHARACTER_NULL;
    }
}
