package com.bnppf.kata;

public class TicTacToeGame {
    private static final int GRID_ZERO = 0;
    private static final int NUMBER_OF_GRIDS_IN_GAME_BOARD = 3;
    private static final char FIRST_PLAYER = 'X';
    private char[][] ticTacToeGameBoard;

    public TicTacToeGame() {
        ticTacToeGameBoard = new char[NUMBER_OF_GRIDS_IN_GAME_BOARD][NUMBER_OF_GRIDS_IN_GAME_BOARD];
    }
    public char getTicTacToeGameBoard(int row, int column) {
        return ticTacToeGameBoard[row][column];
    }

    public void markPlayerXAtRowZeroColumnZeroInGameBoard() {
        ticTacToeGameBoard[GRID_ZERO][GRID_ZERO] = FIRST_PLAYER;
    }
}
