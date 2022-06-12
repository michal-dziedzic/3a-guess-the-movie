import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner fileScanner2 = new Scanner(file);
        int randomMovie =chooseRandomMovie(movieTitleCount(fileScanner));
        //line.toCharArray()
        System.out.println(randomMovie);
        System.out.println(loadMovieTitle(fileScanner2, randomMovie));


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

    private static int chooseRandomMovie (int movieTitleCount) {
        System.out.println(movieTitleCount);
        return (int) (Math.random() * movieTitleCount);
    }


}
