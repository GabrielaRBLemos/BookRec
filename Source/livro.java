public class livro {
    String book_id[];
    String title[100];
    int publicationYear;
    ArrayList<String> descriptor;
    public String[] getBook_id() {
        return book_id;
    }
    public livro(String[] book_id, int publicationYear, ArrayList<String> descriptor) {
        this.book_id = book_id;
        this.publicationYear = publicationYear;
        this.descriptor = descriptor;
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