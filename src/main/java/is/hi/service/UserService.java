package is.hi.service;


import is.hi.model.AverageRating;
import is.hi.model.userAccess;
import is.hi.model.Review;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Service class for the campsites
 */

public interface UserService {
    boolean isPwCorr(String nafn, String password);
    boolean hasAdminAuthority(String uname, String psw);
    boolean isPwLegal(String password);
    boolean isUsernameLegal(String username);
    void newLoginUser(userAccess user);
    boolean doesUserExist(String username, String email);
    boolean arePWidentical(String pw1, String pw2);
    //Sem sagt tekur inn eitthvað nafn, annaðhvort
    //campname eða notendanafn og skilar reviewinu
    ArrayList getReviews(String name);
    double getRating(String name);
    void setRating(AverageRating rating);
    ArrayList getUser(String name);
    void addReview(Review review);
    void setAvRating(double r, String name);
    ArrayList getRatings(String name);
    ArrayList getAllReviews();
    void changePassword(String newPassword, String user);
    userAccess getUserInfo(String name);
}
