package is.hi.service;


import is.hi.model.AverageRating;
import is.hi.model.userAccess;
import is.hi.model.Review;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;



public interface UserService {
    boolean isPwCorr(String nafn, String password);
    boolean hasAdminAuthority(String uname, String psw);
    void newLoginUser(String username, String email, String pw1);
    boolean doesUserExist(String username, String password);
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
}
