import java.util.ArrayList;

public class TBRBook extends book{
    private boolean priority;

    public TBRBook(ArrayList<String> idAuthor, String id, String title, String publicationYear, boolean priority) {
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
