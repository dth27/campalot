package is.hi.model;

import javax.persistence.*;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * AverageRating class that holds information of how many users have given a rating
 * and what the rating is.
 */
@Entity
@Table(name="rating")
public class AverageRating {
    @Id
    int id;
    @Column(name = "username")
    String username;
    int rating;
    String campname;

    public AverageRating(int rating, String username, String campname) {
        this.rating = rating;
        this.username = username;
        this.campname = campname;
    }

    public AverageRating() {
    }

        public int getRating () {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCampname() {
        return campname;
    }

    public void setCampname(String campname) {
        this.campname = campname;
    }

}