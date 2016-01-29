
/**
 * Write a description of class PlayGame here.
 * 
 * @author Hannah Pang
 * @version January 29, 2016
 */

import java.util.*;

public class PlayGame
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            Player A = new Player();
            int positionA = 0;
            Player B = new Player();
            int positionB = 0;
            int currentMove = console.nextInt();
            positionA = A.moveCells(currentMove);
            while (currentMove != 0) {
                currentMove = console.nextInt();
                positionB = B.moveCells(currentMove);
                if (positionB == positionA) {
                    A.returnToStart();
                }
                currentMove = console.nextInt();
                positionA = A.moveCells(currentMove);
                if (positionA == positionB) {
                    B.returnToStart();
                }
            }
            System.out.println("Output #" + i + ": A-" + positionA + ", B-" + positionB);
        }
    }
}
