import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

    public static List<autor> readAuthors(){
        String authorsFile = changeAuthorsPathBasedOnOS();
        List<autor> authors = new ArrayList<>();
        
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

    public static List<livroLido> readRead(){
        String readBooksFile = changeReadPathBasedOnOS();
        List<livroLido> readBookList = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File(readBooksFile))) {
            scanner.useDelimiter(",|\\n");
            while (scanner.hasNext()) {
                String idAutor = scanner.next();
                String title = scanner.next();
                String publicationYear = scanner.next();
                String descriptor = scanner.next();

                livroLido newRead = new livroLido(null, title, publicationYear, null);
                readBookList.add(newRead);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + readBooksFile);
            e.printStackTrace();
        }
        
        return readBookList;
    }



    public static void main(String[] args) {
        List<autor> authors = readAuthors();
        for (autor a : authors) {
            System.out.println("ID: " + a.getId());
            System.out.println("Nome: " + a.getNome());
            System.out.println("País: " + a.getPais());
            System.out.println("Nascimento: " + a.getNascimento());
            System.out.println("Is Alive: " + a.getIsAlive());
            System.out.println();
        }
    }
}
