package is.hi.service;

import org.springframework.stereotype.Service;


public interface UserService {
    public boolean isPwCorr(String nafn, String password);
    public void newTraveller(String username, String email, String pw1);
    public boolean doesTravellerExist(String username, String password);
    public boolean arePWidentical(String pw1, String pw2);
}
