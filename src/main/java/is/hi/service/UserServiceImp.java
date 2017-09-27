package is.hi.service;

import is.hi.model.Traveller;
import is.hi.repository.travellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    travellerRepository travRep;

    private ArrayList<Traveller> tList;

    @Override
    public boolean isPwCorr(String uname, String psw) {
        tList = (ArrayList<Traveller>) travRep.getAll();
        for (Traveller t : tList) {
            if (uname.equals(t.getUsername()) && psw.equals(t.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void newTraveller(String username, String email, String pw1) {

            Traveller traveller = new Traveller(username, email, pw1);
            tList.add(traveller);
    }

    @Override
    public boolean doesTravellerExist(String username, String email) {
        tList = (ArrayList<Traveller>) travRep.getAll();
        for (Traveller t : tList) {
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