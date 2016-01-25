
/**
 * Using "GolfScorecard" object
 * Prompts user for information (hole number, par, actual score) for the four input holes
 * Prints out type of hole played for each hole
 * Prints out final cumulative result for four input holes
 * 
 * @author Hannah Pang
 * @version January 24, 2016
 */

import java.util.*;

public class GolfScorecardTestDrive
{
    public static void main(String[] args)
    { 
        Scanner console = new Scanner(System.in);
        
        // this instance will keep track of the cumulative totals (par and actual score), which start off as 0
        GolfScorecard total = new GolfScorecard(0, 0, 0);
        
        for (int i = 0; i < 4; i++) {
            System.out.print("Type input (ex \"1. 5 4\"): ");
            String input = console.nextLine();
            int holeNumber = i + 1;
            int par = Integer.parseInt(input.substring(3, 4));
            int actual = Integer.parseInt(input.substring(5));
            
            // create new instance for this particular hole, print out name of the type of hole played
            GolfScorecard g = new GolfScorecard(holeNumber, par, actual);
            System.out.println(g.score());
            
            // update cumulative totals (par and actual score) with the current hole being analyzed
            total.add(g);
        }
        
        // print out cumulative score based on cumulative par and cumulative actual score for the four input holes
        System.out.println();
        System.out.println("5. " + total.finalScore());

    }
}
