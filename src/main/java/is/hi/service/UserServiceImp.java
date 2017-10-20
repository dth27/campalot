package is.hi.service;

import is.hi.model.*;
import is.hi.repository.reviewRepository;
import is.hi.repository.userRepository;
import is.hi.repository.ratingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
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
    @Autowired
    ratingRepository ratRep;

    private ArrayList<userAccess> tList;

    @Override
    //Checks if the password is correct
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
        travRep.add(username, email, pw1, Boolean.FALSE, Boolean.FALSE);
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
    //Checks if passwords are identical
    public boolean arePWidentical(String pw1, String pw2){
        return pw1.equals(pw2);
    }

    @Override
    //Gets all reviews for the campsite that the user is looking at
    public ArrayList getReviews(String name){
        ArrayList<Review> reviews = new ArrayList<Review>();
        ArrayList<Review> selectedReviews = new ArrayList<Review>();
        reviews = revRep.getAll();
        for (Review rev : reviews){
            if (rev.getCampname().equals(name)) {
                selectedReviews.add(rev);
            }
        }
        return selectedReviews;
    }

    @Query
    //Adds a review, campname and username into table review
    public void addReview(Review review) {
        revRep.addReview(review.getReview(), review.getCampname(), review.getUsername());
    }

    @Override
    //Calculates average rating for the campsite that the user is
    //looking at
    public double getRating(String name){
        double rate = 0;
        int count = 0;
        ArrayList<AverageRating> rating = ratRep.getAll();
        for (int i = 0; i<rating.size(); i++){
            if(rating.get(i).getCampname().equals(name) ||rating.get(i).getUsername().equals(name)) {
               rate += rating.get(i).getRating();
               count++;
            }
        }
        if (count==0){
            return rate;
        }
        double avgrating = Math.round((rate/count)*100) / 100.0;
        return avgrating;
    }

    @Override
    //Gets all ratings and puts them in an ArrayList
    public ArrayList getRatings(String name){
        ArrayList<AverageRating> ratings = new ArrayList<AverageRating>();
        ArrayList<AverageRating> selectedRatings = new ArrayList<AverageRating>();
        ratings = ratRep.getAll();
        for (AverageRating rat : ratings){
            if (rat.getCampname().equals(name)) {
                selectedRatings.add(rat);
            }
        }
        return selectedRatings;
    }

    @Query
    //Sets the rating, username and campsite name into table rating
    public void setRating(AverageRating rating){
        ratRep.addRating(rating.getUsername(), rating.getRating(), rating.getCampname());
    }

    @Query
    //Sets the average rating into table campsitebigdata
    public void setAvRating(double r, String name){
        ratRep.setAvRating(r, name);
    }

    @Override
    //TODO hvað gerir þetta??
    public ArrayList getUser(String username){
    tList = (ArrayList<userAccess>) travRep.getUserfromname(username);
        return tList;
    }

}

