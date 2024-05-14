import java.util.ArrayList;

public class TBRBook extends book{
    private boolean priority;

    public TBRBook(ArrayList<String> idAuthor, String title, String publicationYear, ArrayList<String> descriptor,
            boolean priority) {
        super(idAuthor, title, publicationYear, descriptor);
        this.priority = priority;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
