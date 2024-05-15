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

    public static String changeAuthorshipPathBasedOnOS(){
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            return "Data\\Authorship.csv";             
        }
        return "Data/Authorship.csv";
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

                readBook readBook = new readBook(id, title, publicationYear, rating);
                readBookList.add(readBook);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + readBooksFile);
            e.printStackTrace();
        }

        return readBookList;
    }

    public static ArrayList<authorship> readAuthorship() {
        String authorshipFile = changeAuthorshipPathBasedOnOS();
        ArrayList<authorship> authorshipList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(authorshipFile))) {
            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {
                String bookId = scanner.next();
                String authorId = scanner.next();

                authorship authorship = new authorship(bookId, authorId);
                authorshipList.add(authorship);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + authorshipFile);
            e.printStackTrace();
        }

        return authorshipList;
    }

    public static String getAuthorNameById(String authorId, ArrayList<author> authorList){
        String authorName = null;

        for (author author : authorList) {
            if (authorId.equals(author.getId())) {
                authorName = author.getName();
                break;
            }
        }

        return authorName;
    }

    public static ArrayList<String> getAuthorsForBook(String bookId, ArrayList<authorship> authorshipList, ArrayList<author> authorList) {
        ArrayList<String> bookAuthors = new ArrayList<>();
        String authorName;
        for (authorship authorship : authorshipList) {
            if (authorship.getBookId().equals(bookId)) {
                authorName = getAuthorNameById(authorship.getAuthorId(), authorList);
                if (authorName == null) {
                    authorName = authorship.getAuthorId();
                }
                else{
                    bookAuthors.add(authorName);
                }
            }
        }
        return bookAuthors;
    }

    // TODO: reader for TBRBook
    public static void main(String[] args) {
        ArrayList<author> authorList = readAuthors();
        ArrayList<readBook> readBookList = readReadBooks();
        ArrayList<authorship> authorshipList = readAuthorship();
        ArrayList<String> bookAuthorship;

        for (author a : authorList) {

            System.out.println("ID: " + a.getId());
            System.out.println("Name: " + a.getName());
            System.out.println("Country: " + a.getCountry());
            System.out.println("Birth Year: " + a.getBirthYear());
            System.out.println("Is Alive: " + a.getIsAlive());
            System.out.println();
        }
        for (readBook rb : readBookList) {

            bookAuthorship = getAuthorsForBook(rb.getId(), authorshipList, authorList);

            System.out.println("ID: " + rb.getId());
            System.out.println("Title: " + rb.getTitle());
            System.out.println("Publication: " + rb.getPublicationYear());
            System.out.println("Rating: " + rb.getRating());
            System.out.println("Authors:" + bookAuthorship);
            System.out.println();
        }
    }
}
