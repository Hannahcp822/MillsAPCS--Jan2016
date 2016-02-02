
/**
 * Write a description of class PlayACSLLAND here.
 * 
 * @author Hannah Pang
 * @version February 1, 2016
 */

import java.util.*;

public class PlayACSLLAND
{
    public static void main(String[] args) 
    {
        Scanner console = new Scanner(System.in);
        
        // Play 5 games
        for (int i = 1; i <= 5; i++) {
            Game g = new Game();
            System.out.print("Output #" + i + ": ");
            g.play(console);
        }
    }
}

