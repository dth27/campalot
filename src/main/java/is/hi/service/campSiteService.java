package is.hi.service;



import is.hi.model.Campsites;



/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 */

import java.util.ArrayList;


public interface campSiteService {
    Campsites getOneCampinfo(String name);
    ArrayList getCampinfo();
    boolean doesCampExist(String campname);
    void addNewCamp(Campsites camp);
    void delCamp(String campname);
    void updateCamp(Campsites camp);
    int countCampInfo();
    boolean erALifi();
    ArrayList getAmenities(String campname);
}