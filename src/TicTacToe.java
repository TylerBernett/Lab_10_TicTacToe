import java.util.Scanner;

public class TicTacToe
{
    private static final int ROWS = 3;
    private static final int COLS = 3;

    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        boolean playAgain;

        // game loop
        do
        {
            clearBoard();

            String player = "X";

            int moves = 0;

            boolean gameOver = false;

            while(!gameOver)
            {
                // display the board
                display();

                int row;
                int col;

                do
                {
                    // get the player row
                    row = SafeInput.getRangedInt(in, player + " enter row", 1, 3) - 1;

                    // get the player column
                    col = SafeInput.getRangedInt(in, player + " enter column", 1, 3) - 1;

                    if(!isValidMove(row, col))
                    {
                        System.out.println("That position is already taken!");
                    }

                }while(!isValidMove(row, col));

                // place move
                board[row][col] = player;

                // move counter
                moves++;

                if(moves >= 5)
                {
                    // check for a win
                    if(isWin(player))
                    {
                        display();
                        System.out.println(player + " wins!");
                        gameOver = true;
                    }
                    // check for a tie
                    else if(isTie())
                    {
                        display();
                        System.out.println("Tie Game!");
                        gameOver = true;
                    }
                }

                if(!gameOver)
                {
                    // switch the player
                    if(player.equals("X"))
                    {
                        player = "O";
                    }
                    else
                    {
                        player = "X";
                    }
                }
            }
            // ask to play again
            playAgain = SafeInput.getYNConfirm(in, "Play again?");

        }while(playAgain);

        // goodbye
        System.out.println("Goodbye!");

    }
    private static void clearBoard()
    {
        for(int r = 0; r < ROWS; r++)
        {
            for(int c = 0; c < COLS; c++)
            {
                board[r][c] = " ";
            }
        }
    }

    private static void display()
    {
        System.out.println();

        for(int r = 0; r < ROWS; r++)
        {
            System.out.print(" ");

            for(int c = 0; c < COLS; c++)
            {
                System.out.print(board[r][c]);

                if(c < COLS - 1)
                {
                    System.out.print(" | ");
                }
            }

            System.out.println();

            if(r < ROWS - 1)
            {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }

    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

    private static boolean isRowWin(String player)
    {
        for(int r = 0; r < ROWS; r++)
        {
            if(board[r][0].equals(player) &&
                    board[r][1].equals(player) &&
                    board[r][2].equals(player))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isColWin(String player)
    {
        for(int c = 0; c < COLS; c++)
        {
            if(board[0][c].equals(player) &&
                    board[1][c].equals(player) &&
                    board[2][c].equals(player))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        if(board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player))
        {
            return true;
        }

        if(board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player))
        {
            return true;
        }

        return false;
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player)
                || isColWin(player)
                || isDiagonalWin(player);
    }

    private static boolean isTie()
    {
        for(int r = 0; r < ROWS; r++)
        {
            for(int c = 0; c < COLS; c++)
            {
                if(board[r][c].equals(" "))
                {
                    return false;
                }
            }
        }

        return true;
    }


}