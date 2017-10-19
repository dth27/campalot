package is.hi.model;

import javax.persistence.*;

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
    @Column(name="username")
    String username;
    String review;
    String campname;
   /* @OneToMany
    @JoinColumn(name= "username")
    Set<userAccess> userAccess;
    String review;
    @OneToMany
    @JoinColumn(name = "campname")
    private Set<Camp> camp;
    //@Column(name = "rating")
    private
    int rating;*/


    public Review(String review, String username, String campname) {
        this.review = review;
        this.username = username;
        this.campname = campname;
    }

    public Review() {
    }
    /*
    public Set<is.hi.model.userAccess> getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(Set<is.hi.model.userAccess> userAccess) {
        this.userAccess = userAccess;
    }

    public Set<Camp> getCamp() {
        return camp;
    }

    public void setCamp(Set<Camp> camp) {
        this.camp = camp;
    }*/

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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
