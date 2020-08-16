package com.bnppf.kata;

public class TicTacToeGame {
    private char[][] ticTacToeGameBoard = new char[3][3];

    public char getTicTacToeGameBoard(int row, int column) {
        return ticTacToeGameBoard[row][column];
    }
}
