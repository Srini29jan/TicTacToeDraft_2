package com.bnppf.kata.simulation;

import com.bnppf.kata.TicTacToeGame;
import com.bnppf.kata.exception.InvalidMoveException;

import java.io.IOException;
import java.util.Scanner;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.WARNING;

public class SimulateTicTacToe {

    private static final char CELL_SEPARATOR = '|';
    private static final char CHARACTER_REPRESENTING_GAME_DRAWN = 'D';
    private static final char EMPTY_CELL = '_';
    private static final char FIRST_PLAYER = 'X';
    private static final char INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD = '\0';
    private static final char SECOND_PLAYER = 'O';
    private static final int FIRST_COLUMN_INDEX = 0;
    private static final int INITIAL_INPUT_CELL_VALUE = -1;
    private static final int FIRST_ROW_INDEX = 0;
    private static final int LAST_COLUMN_INDEX = 2;
    private static final int LAST_ROW_INDEX = 2;
    private static final Logger LOGGER = Logger.getLogger(SimulateTicTacToe.class.getName());
    private static final String LINE_FEED = "\n";
    private static final String LOG_FILE_PATH = "C:\\temp\\info.log";
    private static final String MESSAGE_TO_ANNOUNCE_DRAW = "The game is a draw!";
    private static final String MESSAGE_TO_ANNOUNCE_WINNER = "The winner of this game is : ";
    private static final String MESSAGE_TO_REQUEST_INPUT = "Please enter the value of row and column, in the format <row> <column>, in which you would like to play. Eg: 0 0";

    public static void main(String[] args) {
        initializeFileHandler();
        Scanner keyboardInput = new Scanner(System.in);
        int inputRow = INITIAL_INPUT_CELL_VALUE;
        int inputColumn = INITIAL_INPUT_CELL_VALUE;
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        char winnerOfTheGame = ticTacToeGame.checkForWinnerInTheGame();
        while (winnerOfTheGame != FIRST_PLAYER && winnerOfTheGame != SECOND_PLAYER && winnerOfTheGame != CHARACTER_REPRESENTING_GAME_DRAWN) {
            LOGGER.log(INFO, MESSAGE_TO_REQUEST_INPUT);
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
            fileHandler = new FileHandler(LOG_FILE_PATH);
            LOGGER.addHandler(fileHandler);
        } catch (SecurityException securityException) {
            LOGGER.log(WARNING, securityException.getMessage());
        } catch (IOException ioException) {
            LOGGER.log(WARNING, ioException.getMessage());
        }
    }

    private static void printTheResultOfTheGame(char winner) {
        if (winner == FIRST_PLAYER || winner == SECOND_PLAYER) {
            LOGGER.log(INFO, MESSAGE_TO_ANNOUNCE_WINNER + winner);
        } else if (winner == CHARACTER_REPRESENTING_GAME_DRAWN) {
            LOGGER.log(INFO, MESSAGE_TO_ANNOUNCE_DRAW);
        }
    }

    private static void printBoard(TicTacToeGame ticTacToeGame, int row, int column) {
        StringBuilder gameBoardPrintBuilder = new StringBuilder(LINE_FEED);
        for (int rowIndex = FIRST_ROW_INDEX; rowIndex <= LAST_ROW_INDEX; rowIndex++) {
            for (int columnIndex = FIRST_COLUMN_INDEX; columnIndex <= LAST_COLUMN_INDEX; columnIndex++) {
                if (ticTacToeGame.getTicTacToeGameBoard(rowIndex, columnIndex) == INITIAL_VALUE_OF_A_CELL_IN_GAME_BOARD) {
                    gameBoardPrintBuilder.append(EMPTY_CELL);
                } else {
                    gameBoardPrintBuilder.append(Character.toString(ticTacToeGame.getTicTacToeGameBoard(rowIndex, columnIndex)));
                }
                if (columnIndex < LAST_COLUMN_INDEX) {
                    gameBoardPrintBuilder.append(CELL_SEPARATOR);
                } else {
                    gameBoardPrintBuilder.append(LINE_FEED);
                }
            }
        }
        gameBoardPrintBuilder.append(LINE_FEED);
        LOGGER.log(INFO, gameBoardPrintBuilder.toString());
    }
}