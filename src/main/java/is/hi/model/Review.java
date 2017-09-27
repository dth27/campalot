package is.hi.model;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Review klasi sem inniheldur review notenda
 */

public class Review {
    String review;

    public Review(String review, String username) {
        this.review = review;
        this.username = username;
    }

    String username;


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
}
