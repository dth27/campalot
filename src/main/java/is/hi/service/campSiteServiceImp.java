package is.hi.service;
import is.hi.model.Camp;
//import is.hi.model.loginUser;
import is.hi.model.Campinfo;
import is.hi.model.Review;
import is.hi.repository.campinfoRepository;
import is.hi.repository.campsiteRepository;
import is.hi.repository.reviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 */
@Service
public class campSiteServiceImp implements campSiteService {
    @Autowired
    campsiteRepository campRep;
    @Autowired
    campinfoRepository campInfoRep;
    @Autowired
    reviewRepository revRep;

    private ArrayList<Camp> cList;
    private ArrayList<Campinfo> BList;
    private ArrayList<Review> rList;
    @Override
    public ArrayList getCampsites(){
        cList = (ArrayList<Camp>) campRep.getAll();
        return cList;
    }
    @Override
    public Camp getOneCamp(String campname){
        cList = (ArrayList<Camp>) campRep.getAll();
        Camp camp1 = null;
        for (Camp camp : cList){
            if (camp.getCampname().equals(campname)){
                camp1 = camp;
                return camp1;
            }
        }
        return camp1;
    }
    @Override
    public Campinfo getOneCampinfo(String name){
        BList = (ArrayList<Campinfo>) campInfoRep.getAll();
        Campinfo camp1 = null;
        for (Campinfo camp : BList){
            if (camp.getCampname().equals(name)){
                camp1 = camp;
                return camp1;
            }
        }
        return camp1;
    }

    @Override
    public  ArrayList getCampinfo(){
        BList = (ArrayList<Campinfo>) campInfoRep.getAll();
        return BList;
    }

    //Dæmi fyrir test á mockup hvort að þjónustan sé "á lífi"
    @Override
    public boolean erALifi() {return true;}
}