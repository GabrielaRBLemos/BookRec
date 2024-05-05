import java.util.ArrayList;

public class livroTBR extends livro{
    private boolean priority;

    public livroTBR(ArrayList<String> idAutor, String title, String publicationYear, ArrayList<String> descriptor,
            boolean priority) {
        super(idAutor, title, publicationYear, descriptor);
        this.priority = priority;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}