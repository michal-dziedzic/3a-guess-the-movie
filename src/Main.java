import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner fileScanner2 = new Scanner(file);
        Scanner letterScanner= new Scanner(System.in);
        int howManyTimesGuessed = 0;
        int rightGuess = 0;
        boolean flag = false;
        int randomMovie = choseRandomMovie(movieTitleCount(fileScanner));
        String chosenMovieTitle = loadMovieTitle(fileScanner2, randomMovie);
        String[] splitTitle = chosenMovieTitle.split("");
        String[] titleWithGuessedLetters = new String[splitTitle.length];
        for (int i = 0; i < splitTitle.length; i++) {
            System.out.print(splitTitle[i]);
        }
        System.out.println();
        for (int i = 0; i < titleWithGuessedLetters.length; i++) {
            titleWithGuessedLetters[i]="_";
            System.out.print(titleWithGuessedLetters[i]);
        }
        System.out.println();

        while (howManyTimesGuessed<10){
            flag=false;
            System.out.println("Guess a letter: ");
            String letter = letterScanner.nextLine();
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
            System.out.println("trafienia " + rightGuess);
            if(!flag) {
                howManyTimesGuessed++;
                System.out.println(howManyTimesGuessed);
            } else if (splitTitle.length == rightGuess) {
                System.out.println("\nYou guessed " +chosenMovieTitle + " correctly!");
                break;
            }

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


}
