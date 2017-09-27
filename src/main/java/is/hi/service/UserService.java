package is.hi.service;

import org.springframework.stereotype.Service;


public interface UserService {
    boolean isPwCorr(String nafn, String password);
    void newTraveller(String username, String email, String pw1);
    boolean doesTravellerExist(String username, String password);
    boolean arePWidentical(String pw1, String pw2);
    String getReviews(String username);
}
