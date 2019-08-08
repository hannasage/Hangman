import java.util.Scanner;

public class Prompter {
  private Game game;
  
  public Prompter(Game game) {
    this.game = game;
  }
  
  public boolean promptForGuess() {
    boolean isHit = false;
    boolean isAcceptable = false;
    Scanner scanner = new Scanner(System.in);
    
    do {
      System.out.print("Enter a letter:  ");
      String guessInput = scanner.nextLine();
      try {
        isHit = game.applyGuess(guessInput);
        isAcceptable = true;
      } catch (IllegalArgumentException iae) {
        System.out.printf("%s. Please try again. %n",
                          iae.getMessage()); 
      }
    } while (!isAcceptable);
    return isHit;
  }
  
  public void displayProgress() {
    System.out.printf("You have %d tries left to solve. Try to solve:  %s%n",
                      game.getRemainingTries(),
                      game.getCurrentProgress());
  }
  
  public void displayOutcome() {
    if (game.isWon()) {
      System.out.printf("You won with %d tries remaining. %n",
                        game.getRemainingTries());
    } else {
      System.out.printf("Sorry, you're out of tries. The word was %s. %n",
                        game.getAnswer());
    }
  }
}