public class autorship {
    private String bookId;
    private String autorId;

    public autorship(String bookId, String autorId) {
        this.bookId = bookId;
        this.autorId = autorId;
    }
    
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getAutorId() {
        return autorId;
    }
    public void setAutorId(String autorId) {
        this.autorId = autorId;
    }
    
}
