import java.util.Scanner;  

public class BookRec {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new File("Data/Autores.csv"));
        reader.useDelimiter(",");
        while (reader.hasNext()){
            System.out.println(reader.next());
        }
        reader.close();
    }
}
