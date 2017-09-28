package is.hi.service;

import org.springframework.stereotype.Service;


public interface UserService {
    boolean isPwCorr(String nafn, String password);
    public boolean hasAdminAuthority(String uname, String psw);
    void newLoginUser(String username, String email, String pw1);
    boolean doesUserExist(String username, String password);
    boolean arePWidentical(String pw1, String pw2);
    String getReviews(String username);
}
