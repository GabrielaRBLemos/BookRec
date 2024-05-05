import java.util.ArrayList;

public class livroLido extends livro{
    private float rating;


    public livroLido(ArrayList<String> idAutor, String title, String publicationYear, ArrayList<String> descriptor, float rating) {
        super(idAutor, title, publicationYear, descriptor);
        this.rating = rating;
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
