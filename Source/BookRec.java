import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRec {
    public static String changePathBasedOnOS(String windowsPath, String generalPath){
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("windows")) {

            return windowsPath;             
        }
        return generalPath;
    }
    public static String changeAuthorsPathBasedOnOS(){ 
        String windowsPath = "Data\\Authors.csv";
        String generalPath = "Data/Authors.csv";
        return changePathBasedOnOS(windowsPath,generalPath);
    }

    public static String changeAuthorshipPathBasedOnOS(){
        String windowsPath = "Data\\Authorship.csv";             
        String generalPath = "Data/Authorship.csv";
        return changePathBasedOnOS(windowsPath,generalPath);
    }

    public static String changeReadPathBasedOnOS(){
        String windowsPath = "Data\\ReadBook.csv";
        String generalPath = "Data/ReadBook.csv";
        return changePathBasedOnOS(windowsPath,generalPath);
    }

    public static String changeTBRPathBasedOnOS(){
        String windowsPath = "Data\\TBRBook.csv";
        String generalPath = "Data/TBRBook.csv";
        return changePathBasedOnOS(windowsPath,generalPath);
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

    public static ArrayList<tBRBook> readTBRBooks(){
        String tBRBooksFile = changeTBRPathBasedOnOS();
        ArrayList<tBRBook> tBRBookList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(tBRBooksFile))) {
            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {
                String id = scanner.next();
                String title = scanner.next();
                String publicationYear = scanner.next();
                Boolean priority = Boolean.parseBoolean(scanner.next());

                tBRBook tBRBook = new tBRBook(id, title, publicationYear, priority);
                tBRBookList.add(tBRBook);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + tBRBooksFile);
            e.printStackTrace();
        }

        return tBRBookList;
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

    public static void printAll( ArrayList<author> authorList, ArrayList<readBook> readBookList, ArrayList<tBRBook> tBRBookList, ArrayList<authorship> authorshipList) {
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

        for (tBRBook tbrb : tBRBookList) {

            bookAuthorship = getAuthorsForBook(tbrb.getId(), authorshipList, authorList);

            System.out.println("ID: " + tbrb.getId());
            System.out.println("Title: " + tbrb.getTitle());
            System.out.println("Publication: " + tbrb.getPublicationYear());
            System.out.println("Priority: " + tbrb.isPriority());
            System.out.println("Authors:" + bookAuthorship);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<author> authorList = readAuthors();
        ArrayList<readBook> readBookList = readReadBooks();
        ArrayList<tBRBook> tBRBookList = readTBRBooks();
        ArrayList<authorship> authorshipList = readAuthorship();


        printAll(authorList, readBookList, tBRBookList, authorshipList);
    }
}
