
import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe {
    //initializing static variables and a static array
    static char g = ' ';
    static char[][] box = {{g, g, g},{g, g, g},{g, g, g}};

    public static void player_x(){
        /*creating a void method for both players, which are relatively the same.
        The int x = 0 because it will continue to run if the space is taken.
        x will be 1 when the space is taken, and the next player will start.
         */
        int x = 0;
        while(x == 0){
            Scanner a = new Scanner(System.in);
            System.out.println("Enter a row (0, 1, or 2) for player x: ");
            int row = a.nextInt();
            System.out.println("Enter a column (0, 1, or 2) for player x: ");
            int column = a.nextInt();
            //this if statement considers the spot is empty or not
            if(box[row][column] == ' '){
                box[row][column] = 'x';
                x++;
            }
            //continues to run while loop
            else{
                System.out.println("The space is already taken!");
            }
        }

    }
    public static void player_o(){
        int x = 0;
        while(x == 0){
            Scanner a = new Scanner(System.in);
            System.out.println("Enter a row (0, 1, or 2) for player o: ");
            int row = a.nextInt();
            System.out.println("Enter a column (0, 1, or 2) for player o: ");
            int column = a.nextInt();
            if(box[row][column] == ' '){
                box[row][column] = 'o';
                x++;
            }
            else{
                System.out.println("The space is already taken!");
            }
        }
    }
    public static void checkGame(){
        //loops through the row iteration of the box, checking for winners
        for(int i = 0; i < box.length; i++){
            if (box[i][0] == box[i][1] && box [i][1] == box[i][2] && box[i][0] != ' '){
                //checks if winner is x or o
                if(box[i][0] == 'x'){
                    System.out.println("Player X wins!");
                } else{
                    System.out.println("Player O wins!");
                }
                //using system.exit feels natural to me
                System.exit(0);
            }
            //checks for the columns
            for(int j = 0; j < box[0].length; j++){
                if (box[0][j] == box[1][j] && box[1][j] == box[2][j] && box [0][j] != ' '){
                    if(box[0][j] == 'x'){
                        System.out.println("Player X wins!");
                    } else{
                        System.out.println("Player O wins!");
                    }
                    System.exit(0);
                }
            }
        }
        // if statements following check the diagonals
        if (box[0][0] == box[1][1] && box[1][1] == box[2][2] && box [0][0] != ' '){
            if(box[0][0] == 'x'){
                System.out.println("Player X wins!");
            } else{
                System.out.println("Player O wins!");
            }
            System.exit(0);
        }
        if (box[0][2] == box[1][1] && box[1][1] == box[2][0] && box [0][2] != ' '){
            if(box[0][2] == 'x'){
                System.out.println("Player X wins!");
            } else{
                System.out.println("Player O wins!");
            }
            System.exit(0);
        }
    }

    public static void printBoard(){
        //new method simply to print the board
        System.out.println("---------------\n" + " | " + box[0][0] + " | "+ box[0][1] + " | "+ box[0][2] +" | ");
        System.out.println("---------------\n" + " | " + box[1][0] + " | "+ box[1][1] + " | "+ box[1][2] +" | ");
        System.out.println("---------------\n" + " | " + box[2][0] + " | "+ box[2][1] + " | "+ box[2][2] +" | ");
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        //the while loop in the main statement will continue to run.
        //until System.exit(0) initiates, the loop continues.
        int i = 0;
        printBoard();
        while(i == 0){
            player_x();
            printBoard();
            checkGame();
            player_o();
            printBoard();
            checkGame();
        }

    }
}
