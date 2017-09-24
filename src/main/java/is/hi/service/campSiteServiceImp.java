package is.hi.service;
import is.hi.model.Camp;
//import is.hi.model.Traveller;
import is.hi.repository.campsiteRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import is.hi.repository.travellerRepository;
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