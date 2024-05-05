import java.util.ArrayList;

public class livro {
    private ArrayList<String> idAutor;
    private String title;
    private String publicationYear;
    private ArrayList<String> descriptor;

    public livro(ArrayList<String> idAutor, String title, String publicationYear, ArrayList<String> descriptor) {
        this.idAutor = idAutor;
        this.title = title;
        this.publicationYear = publicationYear;
        this.descriptor = descriptor;
    }
    public ArrayList<String> getIdAutor() {
        return idAutor;
    }
    public void setIdAutor(ArrayList<String> idAutor) {
        this.idAutor = idAutor;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
    public ArrayList<String> getDescriptor() {
        return descriptor;
    }
    public void setDescriptor(ArrayList<String> descriptor) {
        this.descriptor = descriptor;
    }
    
    
}