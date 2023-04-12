package pl.oleksii;

import java.util.Random;
import java.util.Scanner;

import static pl.oleksii.GameBoard.*;

public class Main {
    public static void main(String[] args) {

        printGameBoard(gameBoard);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your placement: (1-9): ");
            int playerPos = scanner.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Position taken! Enter a correct Position");
                playerPos = scanner.nextInt();
            }
            PlacePiece(gameBoard, playerPos, "player");
            String result = CheckWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = random.nextInt(9) + 1;
            }
            PlacePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);
            result = CheckWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            System.out.println(result);
        }
    }
}