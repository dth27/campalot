package is.hi.model;



import javax.persistence.*;
import java.io.Serializable;

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
    @JoinColumn(referencedColumnName = "userAccess_username")
    String username;
    String review;
    @ManyToMany
    @JoinColumn(name = "campname", referencedColumnName = "campname")
    private Camp camp;
    @Column(name = "rating")
    int rating;


    public Review(int id, String review, String username, String campname, int rating) {
        this.id = id;
        this.review = review;
        this.username = username;
        this.campname = campname;
        this.rating = rating;
    }

    public Review() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getCampname() {
        return campname;
    }

    public void setCampname(String campname) {
        this.campname = campname;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
