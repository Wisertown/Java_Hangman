public class Hangman {
	
	public static void main(String[] args){
	
		Game game = new Game("TOby");
		Prompter prompter = new Prompter(game);
		prompter.displayProgress();
		boolean isHit = prompter.promptForGuess();
		if(isHit){
			System.out.println("we got a hit");
		} else {
			System.out.println("That was a miss");
		}
		prompter.displayProgress();
	}

}