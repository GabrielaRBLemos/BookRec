import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
            return "Data\\ReadBook.csv";             
        }
        return "Data/ReadBook.csv";
    }

    public static ArrayList<author> readAuthors(){

        String authorsFile = changeAuthorsPathBasedOnOS();
        ArrayList<author> authorList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(authorsFile))) {

            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {

                String id = scanner.next();
                String name = scanner.next();
                String country = scanner.next();
                String birthYear = scanner.next();
                boolean isAlive = Boolean.parseBoolean(scanner.next());

                author newAuthor = new author(name, country, birthYear, isAlive, id);
                authorList.add(newAuthor);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + authorsFile);
            e.printStackTrace();
        }
        return authorList;
    }

    public static ArrayList<readBook> readReadBooks() {
        String readBooksFile = changeReadPathBasedOnOS();
        ArrayList<readBook> readBookList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(readBooksFile))) {
            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {
                String id = scanner.next();
                String title = scanner.next();
                String publicationYear = scanner.next();
                float rating = Float.parseFloat(scanner.next());

                // Assuming you have a book constructor that takes ID, title, and publication year
                readBook readBook = new readBook(id, title, publicationYear, rating);
                readBookList.add(readBook);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + readBooksFile);
            e.printStackTrace();
        }

        return readBookList;
    }
    
    // TODO CSV READER TBRBook
    public static void main(String[] args) {
        ArrayList<author> authorList = readAuthors();
        ArrayList<readBook> readBookList = readReadBooks();
        for (author a : authorList) {
            System.out.println("ID: " + a.getId());
            System.out.println("Name: " + a.getName());
            System.out.println("Country: " + a.getCountry());
            System.out.println("Birth Year: " + a.getBirthYear());
            System.out.println("Is Alive: " + a.getIsAlive());
            System.out.println();
        }
        for (readBook rb : readBookList) {
            System.out.println("ID: " + rb.getId());
            System.out.println("Title: " + rb.getTitle());
            System.out.println("Publication: " + rb.getPublicationYear());
            System.out.println("Rating: " + rb.getRating());
            System.out.println();
        }
    }
}
