package com.bnppf.kata;

import com.bnppf.kata.exception.InvalidMoveException;

public class TicTacToeGame {
    private static final int GRID_ONE = 1;
    private static final int GRID_TWO = 2;
    private static final int GRID_ZERO = 0;
    private static final int LOWER_LIMIT_OF_ROW_AND_COLUMN = 0;
    private static final int NUMBER_OF_GRIDS_IN_GAME_BOARD = 3;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_ZERO = 0;
    private static final int UPPER_LIMIT_OF_ROW_AND_COLUMN = 2;
    private static final char CHARACTER_NULL = '\0';
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
        char valueAtFirstCellInFirstRow = getTicTacToeGameBoard(GRID_ZERO, GRID_ZERO);
        char valueAtSecondCellInFirstRow = getTicTacToeGameBoard(GRID_ZERO, GRID_ONE);
        char valueAtThirdCellInFirstRow = getTicTacToeGameBoard(GRID_ZERO, GRID_TWO);
        if (valueAtFirstCellInFirstRow != INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD && valueAtFirstCellInFirstRow == valueAtSecondCellInFirstRow && valueAtSecondCellInFirstRow == valueAtThirdCellInFirstRow) {
            return valueAtFirstCellInFirstRow;
        }
        return CHARACTER_NULL;
    }
}
