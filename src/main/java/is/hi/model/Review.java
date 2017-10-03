package is.hi.model;



import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Review klasi sem inniheldur review notenda
 */
@Entity
@Table (name="review")
public class Review {
    @Id
    int id;

    @OneToMany
    @JoinColumn(name= "userAccess_username")
    Set<userAccess> userAccess;
    String review;
    @OneToMany
    @JoinColumn(name = "Camp_campname")
    private Set<Camp> camp;
    //@Column(name = "rating")
    private
    String rating;


    public Review(int id, String review,userAccess useraccess, Camp camp, int rating) {
        this.id = id;
        this.review = review;
       // this.username = username;
        //this.camp = (List<Camp>) camp;
        //this.campname = campname;
        //this.rating = rating;
    }


    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
