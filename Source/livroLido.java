import java.util.ArrayList;

public class livroLido extends livro{
    private boolean possui;
    private float rating;


    public livroLido(String[] idAutor, String[] title, int publicationYear, ArrayList<String> descriptor,
            boolean possui) {
        super(idAutor, title, publicationYear, descriptor);
        this.possui = possui;
    }

    public boolean isPossui() {
        return possui;
    }

    public void setPossui(boolean possui) {
        this.possui = possui;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
        else{
            System.out.println("Rating can only be between 0 and 5.\n");
        }
    }
}
