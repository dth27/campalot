package is.hi.service;
import is.hi.model.Traveller;
import org.springframework.stereotype.Service;
import is.hi.repository.travellerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Service

public class campSiteServiceImp implements campSiteService {


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
}