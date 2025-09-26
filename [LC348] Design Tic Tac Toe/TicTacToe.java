import java.util.Scanner;

public class TicTacToe {

    static String[] board = {"-", "-", "-",
                             "-", "-", "-",
                             "-", "-", "-"};

    static Scanner sc = new Scanner(System.in);

    public static void printBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    public static void takeTurn(String player) {
        System.out.println(player + "'s turn.");
        String position;
        while (true) {
            System.out.print("Choose a position from 1-9: ");
            position = sc.nextLine();
            if (position.matches("[1-9]")) {
                int pos = Integer.parseInt(position) - 1;
                if (board[pos].equals("-")) {
                    board[pos] = player;
                    break;
                } else {
                    System.out.println("Position already taken. Choose a different position.");
                }
            } else {
                System.out.println("Invalid input. Choose a position from 1-9.");
            }
        }
        printBoard();
    }

    public static String checkGameOver() {
        if ((board[0].equals(board[1]) && board[1].equals(board[2]) && !board[0].equals("-")) ||
            (board[3].equals(board[4]) && board[4].equals(board[5]) && !board[3].equals("-")) ||
            (board[6].equals(board[7]) && board[7].equals(board[8]) && !board[6].equals("-")) ||
            (board[0].equals(board[3]) && board[3].equals(board[6]) && !board[0].equals("-")) ||
            (board[1].equals(board[4]) && board[4].equals(board[7]) && !board[1].equals("-")) ||
            (board[2].equals(board[5]) && board[5].equals(board[8]) && !board[2].equals("-")) ||
            (board[0].equals(board[4]) && board[4].equals(board[8]) && !board[0].equals("-")) ||
            (board[2].equals(board[4]) && board[4].equals(board[6]) && !board[2].equals("-"))) {
            return "win";
        } else {
            for (String s : board) {
                if (s.equals("-")) {
                    return "play";
                }
            }
            return "tie";
        }
    }

    public static void playGame() {
        printBoard();
        String currentPlayer = "X";
        boolean gameOver = false;

        while (!gameOver) {
            takeTurn(currentPlayer);
            String gameResult = checkGameOver();

            if (gameResult.equals("win")) {
                System.out.println(currentPlayer + " wins!");
                gameOver = true;
            } else if (gameResult.equals("tie")) {
                System.out.println("It's a tie!");
                gameOver = true;
            } else {
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            }
        }
    }

    public static void main(String[] args) {
        playGame();
        sc.close();
    }
}
