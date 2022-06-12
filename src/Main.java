import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner fileScanner = new Scanner(file);
        
        //line.toCharArray()
        System.out.println(chooseRandomMovie(movieTitleCount(fileScanner)));


    }

    private static int movieTitleCount (Scanner fileScanner) {
        int numbersOfLinesInFile = 0;
        while (fileScanner.hasNextLine()) {
            String line =fileScanner.nextLine();
            numbersOfLinesInFile++;
        }
        return numbersOfLinesInFile;
    }

    private static int chooseRandomMovie (int movieTitleCount) {
        System.out.println(movieTitleCount);
        return (int) (Math.random() * movieTitleCount);
    }
}
