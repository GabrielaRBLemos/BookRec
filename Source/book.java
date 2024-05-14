import java.util.ArrayList;

public class book{
    private ArrayList<String> idAuthor;
    private String title;
    private String publicationYear;
    private ArrayList<String> descriptor;

    public book(ArrayList<String> idAuthor, String title, String publicationYear, ArrayList<String> descriptor) {
        this.idAuthor = idAuthor;
        this.title = title;
        this.publicationYear = publicationYear;
        this.descriptor = descriptor;
    }
    public ArrayList<String> getIdAuthor() {
        return idAuthor;
    }
    public void setIdAuthor(ArrayList<String> idAuthor) {
        this.idAuthor = idAuthor;
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
