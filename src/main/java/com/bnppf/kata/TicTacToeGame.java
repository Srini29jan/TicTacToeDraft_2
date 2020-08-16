package com.bnppf.kata;

import com.bnppf.kata.exception.InvalidMoveException;

public class TicTacToeGame {
    private static final int GRID_ONE = 1;
    private static final int GRID_ZERO = 0;
    private static final int NUMBER_OF_GRIDS_IN_GAME_BOARD = 3;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_ZERO = 0;
    private static final int UPPER_LIMIT_OF_ROW = 2;
    private static final char FIRST_PLAYER = 'X';
    private static final char SECOND_PLAYER = 'O';
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
        if(row >= 0 && row <= UPPER_LIMIT_OF_ROW) {
            ticTacToeGameBoard[row][column] = player;
            numberOfCellsFilled++;
        } else {
            throw new InvalidMoveException(MESSAGE_FOR_INVALID_POSITION);
        }
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
}
