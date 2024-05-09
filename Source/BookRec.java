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

    public static ArrayList<autor> readAuthors(){

        String authorsFile = changeAuthorsPathBasedOnOS();
        ArrayList<autor> authors = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File(authorsFile))) {

            scanner.useDelimiter(",|\\n");

            while (scanner.hasNext()) {

                String id = scanner.next();
                String nome = scanner.next();
                String pais = scanner.next();
                String nascimento = scanner.next();
                boolean isAlive = Boolean.parseBoolean(scanner.next());
                
                autor newAutor = new autor(nome, pais, nascimento, isAlive, id);
                authors.add(newAutor);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + authorsFile);
            e.printStackTrace();
        }
        return authors;
    }
    
    public static ArrayList<livroLido> readReadBooks(){
        String readBooksFile = changeReadPathBasedOnOS();
        ArrayList<livroLido> readBookList = new ArrayList<>();
    }

    /*WORK IN PROGRESS */
    // public static ArrayList<livroLido> readReadBooks(){
    //     String readBooksFile = changeReadPathBasedOnOS();
    //     ArrayList<livroLido> readBookList = new ArrayList<>();
    //     String Line;
    //         try (Scanner scanner = new Scanner(new File(readBooksFile))) {
    //             while (scanner.hasNextLine()) {
    //                 line = scanner.nextLine();
    //                 String[] parts = line.split(",(?![^\\[]*\\])");
    //             }
    //         }
    //         catch (FileNotFoundException e){
    //             System.err.println("File not found: " + readBooksFile);
    //             e.printStackTrace();
    //         }
    //     return readBookList;
    // }
    /*END OF WORK IN PROGRESS */

    public static void main(String[] args) {
        ArrayList<autor> authors = readAuthors();
        // ArrayList<livroLido> readBooks = readReadBooks();
        for (autor a : authors) {
            System.out.println("ID: " + a.getId());
            System.out.println("Nome: " + a.getNome());
            System.out.println("País: " + a.getPais());
            System.out.println("Nascimento: " + a.getNascimento());
            System.out.println("Is Alive: " + a.getIsAlive());
            System.out.println();
        }
        for (livroLido r : readBooks) {
            System.out.println("titulo: "+ r.getTitle());
        }
    }
}
