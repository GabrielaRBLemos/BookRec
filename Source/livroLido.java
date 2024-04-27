import java.util.ArrayList;

public class livroLido extends livro{
    private boolean possui;

    public livroLido(String[] title, int publicationYear, ArrayList<String> descriptor, boolean possui) {
        super(title, publicationYear, descriptor);
        this.possui = possui;
    }

    public boolean isPossui() {
        return possui;
    }

    public void setPossui(boolean possui) {
        this.possui = possui;
    }
}
