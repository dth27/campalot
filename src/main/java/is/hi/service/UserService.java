package is.hi.service;

import is.hi.model.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;



public interface UserService {
    boolean isPwCorr(String nafn, String password);
    boolean hasAdminAuthority(String uname, String psw);
    void newLoginUser(String username, String email, String pw1);
    boolean doesUserExist(String username, String password);
    boolean arePWidentical(String pw1, String pw2);
    //Sem sagt tekur inn eitthvað nafn, annaðhvort
    //campname eða notendanafn og skilar reviewinu
    ArrayList getReviews(String name);

    void addReview(Review review);
    /*double getRating(String name);
    void setRating(int rate, String campname);*/
}
