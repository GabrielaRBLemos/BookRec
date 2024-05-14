public class tBRBook extends book{
    private boolean priority;

    public tBRBook(String id, String title, String publicationYear, boolean priority) {
        super(id, title, publicationYear);
        this.priority = priority;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
