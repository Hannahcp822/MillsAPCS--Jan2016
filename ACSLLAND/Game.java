
/**
 * Write a description of class Game here.
 * 
 * @author Hannah Pang
 * @version February 1, 2016
 */

import java.util.*;

public class Game {

    private static final int start = 0;     
    private static final int end = 40; 
    
    private static final int A = 0;           // PlayerA is index 0 in the "players" array
    private static final int B = 1;           // PlayerB is index 1 in the "players" array   
    
    private int[] positions;                  // Array of ints will keep track of positions of both players
    
    private String input;                   
    private int currentIndex;               
    
    /**
     * Constructor for objects of class Game
     */
    
    public Game() {
        this.positions = new int[2];          // 2 players, both start at "start" cell
        this.positions[A] = start;            
        this.positions[B] = start;            
        this.currentIndex = 0;                // Start reading integers at index 0 of the input string
    }
    
    public void play(Scanner console)
    {
        input = console.nextLine();
        
        // The first roll is for PlayerA
        int player = A;                       
        int roll = nextRoll();               
        boolean isGameDone = false;           
        
        // Keep playing (reading inputs) until someone reaches "End" or there is a '0' in the input string
        while ((roll != 0) && isGameDone == false) { 
            isGameDone = move(player, roll);        
            player = (player + 1) % 2;       
            roll = nextRoll();
        }
        
        // Print the positions of each player
        printOutput();
    }

    // Update position of player based on what number they roll
    private boolean move(int player, int roll) {

        if (shouldMoveBack(roll) == true) {
            moveBack(player, roll);
        } else { 
            positions[player] += roll;
        }
        
        // Check if cell is occupied by other player
        // If occupied, then player who was on cell returns to start
        if (occupied() == true) {
            returnToStart(player);
        }        
        
        // Return true if player has won, return false otherwise
        return isPlayerAtEnd(player);          
    }
    
    // Reads and returns an integer (roll) from the input string
    private int nextRoll() {
        // Find index of first comma or the end of the input string 
        int index = input.indexOf(',', currentIndex);
        if (index == -1) {
            index = input.length();
        }
        
        int roll = Integer.parseInt(input.substring(currentIndex, index));
        
        // Update "current index" so not continuously reading first number of the input string
        currentIndex = index + 1; 
        
        return roll;
    }
    
    // Return true if the player has reached '40' aka "END" cell
    private boolean isPlayerAtEnd(int player) {
        return positions[player] >= end;              
    }
    
    // Return true if the roll is a 4 or 6
    private boolean shouldMoveBack(int roll) {
        return ((roll == 4) || (roll == 6));        
    }
    
    // Move backwards but not past "START" cell (can only go to 0 minimum)
    private void moveBack(int player, int roll) {
        positions[player] -= Math.min(roll, positions[player]);
    }
    
    // Return true if players have landed on same cell
    private boolean occupied() {
        return positions[A] == positions[B];  
    }
    
    private void returnToStart(int player) {
        if (player == A) {
            positions[B] = start;
        } else {
            positions[A] = start;
        }
    }
    
    private void printOutput() {
        displayPosition(A);
        System.out.print(", ");
        displayPosition(B);
        System.out.println();
    }
    
    private void displayPosition(int player) {
        String name = playerName(player);
        
        // Print "End" if player has reached end cell, otherwise print player's position (cell #) 
        if (isPlayerAtEnd(player) == true) {
            System.out.print(name + "-END");        
        } else {
            System.out.print(name + "-" + positions[player]);
        }
    }
    
    private String playerName(int player) {
        // '0' corresponds to Player A, '1' corresponds to Player B
        if (player == 0) {
            return "A";
        } else {
            return "B";
        }
    }
}