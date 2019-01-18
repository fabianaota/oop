import java.util.Scanner;

public class Game {

    private String guessMovie;
    private String rightLetters;
    private String wrongLetters;
    private int lostPoints;
    private boolean wonGame;

    public Game(String pathname) {
        Movie movies = new Movie(pathname);
        guessMovie = movies.getMovie().trim();
        rightLetters = "";
        wrongLetters = "";
        lostPoints = 0;
        wonGame = false;
    }

    public String getMovieTitle() {
        return guessMovie;
    }

    public String getHiddenTitle() {
        if(rightLetters.equals("")) {
            return guessMovie.replaceAll("[a-zA-Z]", "_");
        }
        else {
            return guessMovie.replaceAll("[^" + rightLetters + "\\s]", "_");
        }
    }

    public String getWrongLetters() {
        return wrongLetters;
    }

    public boolean hasWon() {
        return wonGame;
    }

    public boolean gameOver() {
        if(lostPoints >= 10) {
            return true;
        } else if (!getHiddenTitle().contains("_")) {
            wonGame = true;
            return true;
        }
        return false;
    }

    private String inputLetter() {
        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();
        if(!letter.matches("[a-z]")) {
            System.out.println("That is not a letter.");
            return inputLetter();
        }
        else if(wrongLetters.contains(letter) || rightLetters.contains(letter)) {
            System.out.println("You've already guessed that letter.");
            return inputLetter();
        }
        else {
            return letter;
        }
    }

    public void guessLetter() {
        String guessedLetter = inputLetter();
        if (guessMovie.toLowerCase().contains(guessedLetter)) {
            rightLetters += guessedLetter + guessedLetter.toUpperCase();
        }
        else {
            lostPoints++;
            wrongLetters += " " + guessedLetter;
        }
    }

}