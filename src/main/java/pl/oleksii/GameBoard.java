package pl.oleksii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoard {
    public static ArrayList<Integer> playerPositions = new ArrayList<>();
    public static ArrayList<Integer> cpuPositions = new ArrayList<>();
    public static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] c : gameBoard) {
            System.out.println(c);
        }
        System.out.println();
    }

    public static void PlacePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            cpuPositions.add(pos);
            symbol = 'O';
        }

        switch (pos) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
        }
    }

    public static String CheckWinner() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(3, 5, 7);
        List<Integer> cross2 = Arrays.asList(1, 5, 9);

        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List list : winning) {
            if (playerPositions.containsAll(list)) {
                return "Congratulations, you are winner!";
            } else if (cpuPositions.containsAll(list)) {
                return "CPU wins! Sorry :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT";
            }
        }
        return "";
    }
}
