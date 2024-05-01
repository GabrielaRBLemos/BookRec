import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookRec {
    
    public static String changeAuthorsPathBasedOnOS(){
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName == "windows") {
            return "Data\\Autores.csv";             
        }
        return "Data/Autores.csv";
    }

    public static void readAutores(String AuthorsFile){
        AuthorsFile = changeAuthorsPathBasedOnOS();
        
        try (Scanner scanner = new Scanner(new File(AuthorsFile))) {
            scanner.useDelimiter(",|\\n");
            while (scanner.hasNext()) {
                System.out.print(scanner.next() + "\t");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + AuthorsFile);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readAutores(changeAuthorsPathBasedOnOS());
    }
}
