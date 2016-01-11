import java.io.Console;

public class Prompter {
	private Game mGame;
	
	public Prompter(Game game){
		mGame = game;
	}

	public void play() {
		while(mGame.getRemainingTries() > 0 && !mGame.isSolved()){
			displayProgress();
			promptForGuess();

		}
		if(mGame.isSolved()){
			System.out.printf("Congrats You got the word! with %d tries left. \n", 
				mGame.getRemainingTries());
		} else {
			System.out.printf("I'm sorry the word was %s.\n",
				mGame.getAnswer());
		}
	}

	public boolean promptForGuess(){
		Console console = System.console();
		boolean isHit = false;
		boolean isValidGuess = false;
		while(! isValidGuess){
			String guessAsString = console.readLine("Please enter a guess...");
			try {
				isHit = mGame.applyGuess(guessAsString);
				isValidGuess = true;
			} catch (IllegalArgumentException iae){
				console.printf("%s please try again.\n", iae.getMessage());
			}
		}
		return isHit;
	}

	public void displayProgress() {
		System.out.printf("You have %d tries left to solve: %s\n", 
								mGame.getRemainingTries(),
								mGame.getCurrentProgress());

	}	
}
