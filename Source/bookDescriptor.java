public class bookDescriptor {
    private String bookId;
    private String descriptorId;

    public bookDescriptor(String bookId, String descriptorId) {
        this.bookId = bookId;
        this.descriptorId = descriptorId;
    }
    
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getDescriptorId() {
        return descriptorId;
    }
    public void setDescriptorId(String descriptorId) {
        this.descriptorId = descriptorId;
    }
}
