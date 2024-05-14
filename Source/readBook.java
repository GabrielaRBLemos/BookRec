import java.util.ArrayList;

public class readBook extends book{
    private float rating;

    public readBook(ArrayList<String> idAuthor, String id, String title, String publicationYear, float rating) {
        super(id, title, publicationYear);
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
