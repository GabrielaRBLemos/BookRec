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

    // TODO CSV READER ReadBook
    
    // TODO CSV READER TBRBook
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
        // for (readBook r : readBookList) {
        //     System.out.println("Title: "+ r.getTitle());
        // }
    }
}
