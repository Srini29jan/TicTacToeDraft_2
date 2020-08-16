package com.bnppf.kata;

public class TicTacToeGame {
    private static final int NUMBER_OF_GRIDS_IN_GAME_BOARD = 3;
    private char[][] ticTacToeGameBoard;

    public TicTacToeGame() {
        ticTacToeGameBoard = new char[NUMBER_OF_GRIDS_IN_GAME_BOARD][NUMBER_OF_GRIDS_IN_GAME_BOARD];
    }
    public char getTicTacToeGameBoard(int row, int column) {
        return ticTacToeGameBoard[row][column];
    }
}
