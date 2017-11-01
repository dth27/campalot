package is.hi.service;


import is.hi.model.Camp;
import is.hi.model.Campinfo;
import is.hi.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface campSiteService {
    ArrayList getCampsites();
    Camp getOneCamp(String name);
    Campinfo getOneCampinfo(String name);
    ArrayList getCampinfo();
    boolean doesCampExist(String campname);
    void addNewCamp(Campinfo camp);
    void delCamp(String campname)
    boolean erALifi();
}