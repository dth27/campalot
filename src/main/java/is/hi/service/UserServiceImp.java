package is.hi.service;

import is.hi.model.loginUser;
import is.hi.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    userRepository travRep;

    private ArrayList<loginUser> tList;

    @Override
    public boolean isPwCorr(String uname, String psw) {
        tList = (ArrayList<loginUser>) travRep.getAll();
        for (loginUser t : tList) {
            if (uname.equals(t.getUsername()) && psw.equals(t.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    //Checks if user has admin authority
    public boolean hasAdminAuthority(String uname, String psw) {
        tList = (ArrayList<loginUser>) travRep.getAll();
        for (loginUser t : tList) {
            if (uname.equals(t.getUsername()) && psw.equals(t.getPassword())) {
                if(t.getadminAuth()) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    //Creates a new login user
    public void newLoginUser(String username, String email, String pw1) {
            //Every new user automatically has a non-admin access
            Boolean adminAuthority = true;
            loginUser loginUser = new loginUser(username, email, pw1, adminAuthority);
            tList.add(loginUser);
    }

    @Override
    //Checks if certain username has a login access
    public boolean doesUserExist(String username, String email) {
        tList = (ArrayList<loginUser>) travRep.getAll();
        for (loginUser t : tList) {
            if (username.equals(t.getUsername()) || email.equals(t.getEmail())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean arePWidentical(String pw1, String pw2){
        if (pw1.equals(pw2)){
            return true;
        }
        return false;
    }
    //TODO fall til að ná í reviews
    @Override
    public String getReviews(String username){
        return username;
    }

}