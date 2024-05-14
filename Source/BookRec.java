import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookRec {

    public static String changeAuthorsPathBasedOnOS(){
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("windows")) {

            return "Data\\Authors.csv";             
        }
        return "Data/Authors.csv";
    }
    public static String changeReadPathBasedOnOS(){
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            return "Data\\Read.csv";             
        }
        return "Data/Read.csv";
    }

    public static ArrayList<author> readAuthors(){

        String authorsFile = changeAuthorsPathBasedOnOS();
        ArrayList<author> authors = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(authorsFile))) {

            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {

                String id = scanner.next();
                String name = scanner.next();
                String country = scanner.next();
                String birthYear = scanner.next();
                boolean isAlive = Boolean.parseBoolean(scanner.next());

                author newAuthor = new author(name, country, birthYear, isAlive, id);
                authors.add(newAuthor);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + authorsFile);
            e.printStackTrace();
        }
        return authors;
    }

    public static ArrayList<readBook> readReadBooks(){
        String readBookListFile = changeReadPathBasedOnOS();
        ArrayList<readBook> readBookList = new ArrayList<>();
    }

    /*WORK IN PROGRESS */
    // public static ArrayList<readBook> readReadBooks(){
    //     String readBookListFile = changeReadPathBasedOnOS();
    //     ArrayList<readBook> readBookList = new ArrayList<>();
    //     String Line;
    //         try (Scanner scanner = new Scanner(new File(readBookListFile))) {
    //             while (scanner.hasNextLine()) {
    //                 line = scanner.nextLine();
    //                 String[] parts = line.split(",(?![^\\[]*\\])");
    //             }
    //         }
    //         catch (FileNotFoundException e){
    //             System.err.println("File not found: " + readBookListFile);
    //             e.printStackTrace();
    //         }
    //     return readBookList;
    // }
    /*END OF WORK IN PROGRESS */

    public static void main(String[] args) {
        ArrayList<author> authors = readAuthors();
        // ArrayList<readBook> readBookList = readReadBooks();
        for (author a : authors) {
            System.out.println("ID: " + a.getId());
            System.out.println("Name: " + a.getName());
            System.out.println("Country: " + a.getCountry());
            System.out.println("Birth Year: " + a.getBirthYear());
            System.out.println("Is Alive: " + a.getIsAlive());
            System.out.println();
        }
        for (readBook r : readBookList) {
            System.out.println("Title: "+ r.getTitle());
        }
    }
}
