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
    int px = 30;
    int py = 30; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);

    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jumpright", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
 
    // set up game

    boolean play = true;
    while (play){
      /* Your code here */
      System.out.print("Enter command: ");
      String command = UserInput.getValidInput(validCommands);

      switch (command) { 
        case "right":
        case "r":
        game.movePlayer(px, 0);
        game.springTrap(px, 0);
        if (game.movePlayer(px, 0)<0) {
          score--;
        } else if (game.isTrap(px, 0)) {
          if (game.springTrap(px, 0) > 0) {
            score++;
          } else {
            score--;
          }
        }
        System.out.println("score=" + score);
        break;
        case "jumpleft":
        case "jl":
         game.movePlayer(-2*px,0);
         game.springTrap(-2*px,0);
         if (game.movePlayer(-2*px, 0)<0){
          score--;
         }else if (game.isTrap(px,0)){
            if (game.springTrap(-2*px,0)>0){
            score++;}
            }else {
              score--;
            }
        System.out.println("score=" + score);
         break;
        case "jr":
        case "jumpright":
          game.movePlayer(2*px,0);
          game.springTrap(2*px,0);
          if (game.movePlayer(2*px,0)<0){
            score--;
          }else if (game.isTrap(px,0)){
            if (game.springTrap(px,0)>0){
            score++;} 
            else {
              score--;
            }
          }
          System.out.println("score=" + score);
          break;
        case "left":
        case "l":
          game.movePlayer(-px,0);
          game.springTrap(px,0);
          if (game.movePlayer(-px,0)<0){
            score--;
          }else if (game.isTrap(-px,0)){ // checks if there is a trap
            if (game.springTrap(px,0)>0){ // then spring
            score++;}
            }else {
              score--; // if not then penalty
            }
          System.out.println("score=" + score);
          break;
        case "jump":
        case "jumpup":
        case "ju":
          game.movePlayer(0,-2*py);
          game.springTrap(0,-2*py);
          if (game.movePlayer(0, -2*py) <0){
            score--;
          } else if (game.isTrap(0,-2*py)) {
            if (game.springTrap(0,-2*py)>0){
              score++;} 
            else {
              score--;
            }
          }
          System.out.println("score=" + score);
          break;
        case "up":  
        case "u":
          game.movePlayer(0,-py);
          game.springTrap(0,py);
          if (game.movePlayer(0,-py) <0) {
            score--;
          } else if (game.isTrap(0, py))
            if (game.springTrap(0,py)>0){
            score++; } 
            else {
              score--;
            }
          System.out.println("score=" + score);
          break;
        case "down":
        case "d":
          game.movePlayer(0,py);
          game.springTrap(0,py);
          if (game.movePlayer(0,py) <0) {
            score--;
          } else if (game.isTrap(0, py))
            if (game.springTrap(0,py)>0){
            score++; } 
            else {
              score--;
            }
        System.out.println("score=" + score);
        break;
        case "jd":
        case "jumpdown":
          game.movePlayer(0, 2*py);
          game.springTrap(0,py);
          if (game.movePlayer(0,2*py) < 0) {
            score--;
          } else if (game.isTrap(0,py))
            if (game.springTrap(0,py)>0){
              score++;} else{
                score--;
              }
          System.out.println("score=" + score);
          break;
        case "pickup":
        case "p":
          if (game.pickupPrize()<0){
            score--;
          }else {
            score++;
          }
          System.out.println("score=" + score);
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
          System.out.println("score=" + score);
          break;

        case "quit":
        case "q":
          game.endGame();
          play = false;
          if ((game.endGame() > 0) && (score>0)) {
            score++;
            score = Math.abs(score);
          } else {
            score--;
            game.stopMusic();
            game.playMusic("gameover.wav");
          }
  
            
        break;
          
        default:
          System.out.println("Please Enter a Valid Command.");
          score--;
          System.out.println("score=" + score);
          break;
      }
    


    }



    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}

        