package is.hi.service;

import is.hi.model.Camp;
import is.hi.model.Review;
import is.hi.model.userAccess;
import is.hi.repository.reviewRepository;
import is.hi.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Qualifier("userRepository")
    @Autowired
    userRepository travRep;
    @Qualifier("reviewRepository")
    @Autowired
    reviewRepository revRep;

    private ArrayList<userAccess> tList;

    @Override
    public boolean isPwCorr(String uname, String psw) {
        tList = (ArrayList<userAccess>) travRep.getAll();
        for (userAccess t : tList) {
            if (uname.equals(t.getUsername()) && psw.equals(t.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    //Checks if user has admin authority
    public boolean hasAdminAuthority(String uname, String psw) {
        tList = (ArrayList<userAccess>) travRep.getAll();
        for (userAccess t : tList) {
            if (uname.equals(t.getUsername()) && psw.equals(t.getPassword())) {
                if(t.isHasadminauthority()) {
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
        userAccess UserAccess = new userAccess(username, email, pw1, true, false);
            tList.add(UserAccess);
    }

    @Override
    //Checks if certain username has a login access
    public boolean doesUserExist(String username, String email) {
        tList = (ArrayList<userAccess>) travRep.getAll();
        for (userAccess t : tList) {
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
    public ArrayList getReviews(String name){
        ArrayList<Review> reviews = new ArrayList<Review>();
        ArrayList<Review> selectedReviews = new ArrayList<Review>();
        reviews = revRep.getAll();
        for (Review rev : reviews){
            if (rev.getCampname().equals(name) || rev.getUsername().equals(name)) {
                selectedReviews.add(rev);
            }
        }

        return selectedReviews;
    }

    @Override
    public double getRating(String name){
        double rate = 0;
        int count = 1;
        ArrayList<Review> reviews = revRep.getAll();
        for (int i = 0; i<reviews.size(); i++){
            if(reviews.get(i).getCampname().equals(name) ||reviews.get(i).getUsername().equals(name)) {
               rate += reviews.get(i).getRating();
                count++;
            }
        }
        if (count > 2){
            count -= 1;
        }
        double avgrating = rate/count;
        System.out.println(avgrating);
        return avgrating;
    }
    public void setRating(int rate, String name){

    }

    @Override
    public ArrayList getUser(String username){
    tList = (ArrayList<userAccess>) travRep.getUserfromname(username);
        return tList;
    }
}