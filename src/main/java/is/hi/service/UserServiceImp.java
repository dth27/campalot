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

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Service class for the campsites
 */

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

    /**
     * checks if the password is correct
     * @param uname - username
     * @param psw - password
     * @return - true if password is correct, false otherwise
     */
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

    /**
     * checks if the password is legal
     * @param password - password
     * @return true if legal, false otherwise
     */
    @Override
    public boolean isPwLegal(String password) {
        if (password.length() > 0 && password.length() < 15) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks if username is legal
     * @param username - username
     * @return - true if legal , false otherwise
     */
    @Override
    public boolean isUsernameLegal(String username) {
        if (username.length() > 0 && username.length() < 20) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks if user has admin authority
     * @param uname - username
     * @param psw - password
     * @return - ture if user has authority , false otherwise
     */
    @Override
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

    /**
     * creates a new login user
     * @param user - user
     */
    @Override
    public void newLoginUser(userAccess user) {
        travRep.add(user.getUsername(), user.getEmail(), user.getPassword(), Boolean.FALSE, Boolean.FALSE);
    }

    /**
     * checks if certain username has a login access
     * @param username - username
     * @param email - email
     * @return true if user has access , false otherwise
     */
    @Override
    public boolean doesUserExist(String username, String email) {
        tList = (ArrayList<userAccess>) travRep.getAll();
        for (userAccess t : tList) {
            if (username.equals(t.getUsername()) || email.equals(t.getEmail())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Changes password for user
     * @param newPassword - new password
     * @param user - username
     */
    @Override
    public void changePassword(String newPassword, String user) {
        travRep.changePassword(newPassword, user);
    }

    /**
     * checks if passwords are identical
     * @param pw1 - password 1
     * @param pw2 - password 2
     * @return true if identical , false otherwise
     */
    @Override
    public boolean arePWidentical(String pw1, String pw2){
        return pw1.equals(pw2);
    }

    /**
     * Gets all reviews for the campsite that the user is looking at
     * @param name - name of campsite
     * @return ArrayList of reviews
     */
    @Override
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

    /**
     * Fetches all the reviews
     * @return Arraylist of reviews
     */
    @Override
    public ArrayList getAllReviews() {
        ArrayList<Review> allreviews = new ArrayList<Review>();
        allreviews = revRep.getAll();
        return allreviews;
    }

    /**
     * Adds a review, campname an username into table review
     * @param review - the review
     */
    @Query
    public void addReview(Review review) {
        revRep.addReview(review.getReview(), review.getCampname(), review.getUsername());
    }

    @Override
    /**
     *  //Calculates average rating for the campsite that the user is
     //looking at
     */
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

    /**
     * gets all ratings and puts them in an ArrayList
     * @param name - name of the camp
     * @return
     */
    @Override
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

    /**
     * Sets the rating, username and campsite name into table rating
     * @param rating
     */
    @Query
    public void setRating(AverageRating rating){
        ratRep.addRating(rating.getUsername(), rating.getRating(), rating.getCampname());
    }

    /**
     * Sets the averagae rating into table campsitebigdata
     * @param r rating
     * @param name - name
     */
    @Query
    public void setAvRating(double r, String name){
        ratRep.setAvRating(r, name);
    }

    @Override

    public ArrayList getUser(String username){
    tList = (ArrayList<userAccess>) travRep.getUserfromname(username);
        return tList;
    }

    /**
     * gets information about user
     * @param username - username
     * @return - userAccess object
     */
    @Override
    public userAccess getUserInfo(String username) {
        userAccess user1 = new userAccess();
        tList = (ArrayList<userAccess>) travRep.getAll();
        for (userAccess u : tList) {
            if (u.getUsername().equals(username))
                user1 = u;
        }
        return user1;
    }
}

