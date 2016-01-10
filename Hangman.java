public class Hangman {
	
	public static void main(String[] args){
	
		Game game = new Game("character");
		Prompter prompter = new Prompter(game);
		prompter.play();
	}

}