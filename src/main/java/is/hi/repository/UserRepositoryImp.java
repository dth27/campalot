package is.hi.repository;


import is.hi.model.loginUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Collection of loginUsers
 */

@Repository
public class UserRepositoryImp implements userRepository {
    private final List<loginUser> loginUsers;
   // private loginUser mockTraveller;
    public UserRepositoryImp(){
        this.loginUsers = new ArrayList<loginUser>();
        loginUser loginUser = new loginUser("ofm1", "ofm1@hi.is", "password", false);
        loginUsers.add(loginUser);
        loginUser admin = new loginUser("admin", "admin@admin.is", "admin", true);
        loginUsers.add(admin);
    }

    @Override
    public List<loginUser> getAll(){
        return loginUsers;
    }
    @Override
    public void add (loginUser loginUser){
        loginUsers.add(loginUser);
    }
    //TODO búa til mock obj og lista fyrir Review
    @Override
    public String getReviews(String username){
        for (int i = 0; i< loginUsers.size(); i++){
            if (loginUsers.get(i).equals(username)){
                //TODO loginUsers ætti frekar vera listi af reviews
            }
        }
        return username;
    }
}
