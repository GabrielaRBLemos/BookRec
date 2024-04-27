import java.util.ArrayList;

public class livro {
    // private String bookID[];
    private String title[];
    private int publicationYear;
    private ArrayList<String> descriptor;

    public livro(String[] title, int publicationYear, ArrayList<String> descriptor) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.descriptor = descriptor;
    }
    // public String[] getbookID() {
    //     return bookID;
    // }
    // public void setbookID(String[] bookID) {
    //     this.bookID = bookID;
    // }
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