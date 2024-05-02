import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRec {
    
    public static String changeAuthorsPathBasedOnOS(){
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            return "Data\\Autores.csv";             
        }
        return "Data/Autores.csv";
    }

    public static List<autor> readAutores(){
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

    public static void main(String[] args) {
        List<autor> authors = readAutores();
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
