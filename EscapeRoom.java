/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 0; 
    // individual player moves
    int px = 60;
    int py = 60; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
  
    // set up game

    boolean play = true;
    while (play){
      /* TODO: get all the commands working */
      /* Your code here */
      System.out.print("Enter command: ");
      String command = UserInput.getValidInput(validCommands);

      switch (command) { 
        /* currently supports "right", "left", "up", "down", "r", "l", "u", "d",
      "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd", "q", "quit" */
        case "right":
          game.movePlayer(px,0);
          if (game.springTrap(px,0)>0){
            score++;}
          break;
        case "r":
          game.movePlayer(px,0);
          if (game.springTrap(px,0)>0){
            score++;}
          break;
        case "jumpleft":
         game.movePlayer(-2*px,0);
         if (game.springTrap(-2*px,0)>0){
            score++;}
         break;
        case "jl":
         game.movePlayer(-2*px,0);
         if (game.springTrap(-2*px,0)>0){
            score++;}
         break;
        case "jr":
         game.movePlayer(2*px,0);
         if (game.springTrap(2*px,0)>0){
            score++;}
         break;
        case "jumpright":
          game.movePlayer(2*px,0);
          if (game.springTrap(2*px,0)>0){
            score++;}
        case "left":
          game.movePlayer(-px,0);
          if (game.springTrap(-px,0)>0){
            score++;}
          break;
        case "l":
          game.movePlayer(-px,0);
          if (game.springTrap(-px,0)>0){
            score++;}
          break;
        case "up":
          game.movePlayer(0,-px);
          if (game.springTrap(0,-px)>0){
            score++;}
          break;
        case "jump":
          game.movePlayer(0,-2*px);
          if (game.springTrap(0,-2*px)>0){
            score++;}
          break;      
        case "jumpup":
          game.movePlayer(0,-2*px);
          if (game.springTrap(0,-2*px)>0){
            score++;}
          break;  
        case "ju":
          game.movePlayer(0,-2*px);
          if (game.springTrap(0,-2*px)>0){
            score++;}
          break;  
        case "u":
          game.movePlayer(0,-px); 
          if (game.springTrap(0,-px)>0){
            score++; }
          break;
        case "down":
          game.movePlayer(0,px);
          if (game.springTrap(0,px)>0){
            score++;}
          break;
        case "d":
          game.movePlayer(0,px);
          if (game.springTrap(0,px)>0){
            score++;}
          break;
        case "jd":
          game.movePlayer(0,2*px);
          if (game.springTrap(0,2*px)>0){
            score++;}
          break;   
        case "jumpdown":
          game.movePlayer(0, 2*px);
          if (game.springTrap(0,2*px)>0){
            score++;}
          break;
        case "quit":
          play = false;
          break;
        case "q":
          play = false;
          break;
        case "help":
        case "?":
          System.out.println("right, r: move right" + "\n"+
          "leftl: move left"+ "\n"+
         "up, u: move up" + "\n" +
          "down, d: move down" + "\n" +
         "jumpleft, jl: jump left" + "\n" +
          "jumpright, jr: jump right" + "\n" +
         "jumpdown, jd: jump down" + "\n" +
          "jumpup, ju: jump up" + "\n" +
          "quit, q: quit the game" + "\n" +
          "pickup, p: pick up the coin" + "\n" +
          "replay: replay the game" + "\n" +
          "help, ?: help command");
          break;
        case "replay":
          game.replay();
          System.out.println("Game has been reset");
          System.out.println("Score has been set to 0");

        default:
          System.out.println("Please Enter a Valid Command.");
          break;
      }
    


    }



    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}

        