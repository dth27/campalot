package is.hi.service;
import is.hi.model.Camp;
//import is.hi.model.loginUser;
import is.hi.repository.campsiteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


@Service
public class campSiteServiceImp implements campSiteService {
    @Autowired
    campsiteRepository campRep;

    private ArrayList<Camp> cList;

    @Override
    public ArrayList getCampsites(){
        cList = (ArrayList<Camp>) campRep.getAll();
        return cList;
    }
}