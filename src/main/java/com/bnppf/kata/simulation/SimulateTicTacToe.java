package com.bnppf.kata.simulation;

import com.bnppf.kata.TicTacToeGame;
import com.bnppf.kata.exception.InvalidMoveException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.WARNING;

public class SimulateTicTacToe {

    private static final Logger LOGGER = Logger.getLogger(SimulateTicTacToe.class.getName());

    public static void main(String[] args) {
        initializeFileHandler();
        Scanner keyboardInput = new Scanner(System.in);
        int inputRow = -1;
        int inputColumn = -1;
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        char winnerOfTheGame = ticTacToeGame.checkForWinnerInTheGame();
        while (winnerOfTheGame != 'X' && winnerOfTheGame != 'O' && winnerOfTheGame != 'D') {
            LOGGER.log(INFO, "Please enter the value of row and column, in the format <row> <column>, in which you would like to play. Eg: 0 0");
            if (keyboardInput.hasNextInt()) {
                inputRow = keyboardInput.nextInt();
                inputColumn = keyboardInput.nextInt();
            }
            try {
                ticTacToeGame.markCurrentPlayerAtRowColumnInGameBoard(inputRow, inputColumn);
                printBoard(ticTacToeGame, inputRow, inputColumn);
            } catch (InvalidMoveException e) {
                LOGGER.log(WARNING, e.getMessage());
            }
            winnerOfTheGame = ticTacToeGame.checkForWinnerInTheGame();
        }
        printTheResultOfTheGame(winnerOfTheGame);
        keyboardInput.close();
    }

    private static void initializeFileHandler() {
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("C:\\temp\\info.log");
            LOGGER.addHandler(fileHandler);
        } catch (SecurityException securityException) {
            LOGGER.log(WARNING, securityException.getMessage());
        } catch (IOException ioException) {
            LOGGER.log(WARNING, ioException.getMessage());
        }
    }

    private static void printTheResultOfTheGame(char winner) {
        if (winner == 'X' || winner == 'O') {
            LOGGER.log(INFO, "The winner of this game is : "+ winner);
        } else if (winner == 'D') {
            LOGGER.log(INFO, "The game is a draw!");
        }
    }

    private static void printBoard(TicTacToeGame ticTacToeGame, int row, int column) {
        StringBuilder gameBoardPrintBuilder = new StringBuilder("\n");
        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 3; columnIndex++) {
                if (ticTacToeGame.getTicTacToeGameBoard(rowIndex, columnIndex) == '\0') {
                    gameBoardPrintBuilder.append("_");
                } else {
                    gameBoardPrintBuilder.append(Character.toString(ticTacToeGame.getTicTacToeGameBoard(rowIndex, columnIndex)));
                }
                if (columnIndex < 2) {
                    gameBoardPrintBuilder.append("|");
                } else {
                    gameBoardPrintBuilder.append("\n");
                }
            }
        }
        gameBoardPrintBuilder.append("\n");
        LOGGER.log(INFO, gameBoardPrintBuilder.toString());
    }
}