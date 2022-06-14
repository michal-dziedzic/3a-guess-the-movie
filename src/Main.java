import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner fileScanner2 = new Scanner(file);
        Scanner letterScanner= new Scanner(System.in);
        int wrongGuess = 0;
        int rightGuess = 0;
        boolean flag;
        int randomMovie = choseRandomMovie(movieTitleCount(fileScanner));
        String chosenMovieTitle = loadMovieTitle(fileScanner2, randomMovie);
        String[] splitTitle = chosenMovieTitle.split("");
        String[] titleWithGuessedLetters = new String[splitTitle.length];
        String wrongLetterStream="";
        displayTheHiddenTitle(titleWithGuessedLetters);
        System.out.println();
        while (wrongGuess<10){
            flag=false;
            System.out.println("Guess a letter: ");
            String letter = letterScanner.nextLine();
            System.out.print("You are guessing:");
            for (int i = 0; i < splitTitle.length; i++) {
                if (letter.equals(splitTitle[i])){
                    if (titleWithGuessedLetters[i].equals(letter)){
                        rightGuess--;
                    }
                    titleWithGuessedLetters[i] = letter;
                    System.out.print(titleWithGuessedLetters[i]);
                    flag = true;
                    rightGuess++;
                } else {
                    System.out.print(titleWithGuessedLetters[i]);
                }
            }
            if(!flag) {
                wrongGuess++;
                wrongLetterStream=wrongLetterStream.concat(" " +letter);
            } else if (splitTitle.length == rightGuess) {
                System.out.println("\nYou guessed " +chosenMovieTitle.toUpperCase() + " correctly!");
                break;
            }
            System.out.println("\nYou have guessed (" + wrongGuess + "} wrong letters " +wrongLetterStream);
            isGameOver(wrongGuess);
        }

    }

    private static int movieTitleCount (Scanner fileScanner) {
        int numbersOfLinesInFile = 0;
        while (fileScanner.hasNextLine()) {
            fileScanner.nextLine();
            numbersOfLinesInFile++;
        }
        return numbersOfLinesInFile;
    }

    private static String loadMovieTitle (Scanner fileScanner, int randomMovie){
        int lineNumber = 0;
        String movieTitle = null;
        while (fileScanner.hasNextLine()) {
            movieTitle = fileScanner.nextLine();
            if (lineNumber == randomMovie) {
                break;
            }
            lineNumber++;

        }
        return movieTitle;
    }

    private static int choseRandomMovie(int movieTitleCount) {
        return (int) (Math.random() * movieTitleCount);
    }

    private static void isGameOver (int howManyTimesGuessed) {
        if (howManyTimesGuessed==10) {
            System.out.println("Game Over");
        }
    }

    private static void displayTheHiddenTitle (String[] titleWithGuessedLetters) {
        System.out.print("You are guessing:");
        for (int i = 0; i < titleWithGuessedLetters.length; i++) {
            titleWithGuessedLetters[i]="_";
            System.out.print(titleWithGuessedLetters[i]);
        }
    }
}
