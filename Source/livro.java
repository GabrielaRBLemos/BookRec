public class livro {
    private String book_id[];
    private String title[100];
    private int publicationYear;
    private ArrayList<String> descriptor;

    public String[] getBook_id() {
        return book_id;
    }
    public void setBook_id(String[] book_id) {
        this.book_id = book_id;
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