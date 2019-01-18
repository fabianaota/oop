public class Main {

    public static void main(String[] args) {

        Game game = new Game("movies.txt");

        System.out.println("GUESS THE MOVIE!");
        System.out.println("Try to figure out the movie title.");
        System.out.println("Each wrong letter, you lose a point.");
        System.out.println("If you lose 10 points... Game Over!");
        System.out.println("Let's start.");
        System.out.println("The movie title has " + game.getMovieTitle().length() + " characters.");

        while(!game.gameOver()){
            System.out.println("You are guessing:" + game.getHiddenTitle());
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:"
                    + game.getWrongLetters());
            game.guessLetter();
        }
        if(game.hasWon()){
            System.out.println("YOU WIN!");
            System.out.println("You have guessed " + game.getMovieTitle() + " correctly.");
        }
        else{
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:" +
                    game.getWrongLetters());
            System.out.println("YOU LOST!");
            System.out.println("The movie title was " + game.getMovieTitle());
            System.out.println("GAME OVER.");
        }

    }

}