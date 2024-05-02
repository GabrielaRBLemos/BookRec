import java.util.ArrayList;

public class livro {
    private String[] idAutor;
    private String title[];

    private int publicationYear;
    private ArrayList<String> descriptor;

    public livro(String[] idAutor, String[] title, int publicationYear, ArrayList<String> descriptor) {
        this.idAutor = idAutor;
        this.title = title;
        this.publicationYear = publicationYear;
        this.descriptor = descriptor;
    }
    public String[] getIdAutor() {
        return idAutor;
    }
    public void setIdAutor(String[] idAutor) {
        this.idAutor = idAutor;
    }
    public String[] getTitle() {
        return title;
    }
    public void setTitle(String[] title) {
        this.title = title;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public ArrayList<String> getDescriptor() {
        return descriptor;
    }
    public void setDescriptor(ArrayList<String> descriptor) {
        this.descriptor = descriptor;
    }
    
    
}