package is.hi.service;



import is.hi.model.Campinfo;



/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 */

import java.util.ArrayList;


public interface campSiteService {
    Campinfo getOneCampinfo(String name);
    ArrayList getCampinfo();
    boolean doesCampExist(String campname);
    void addNewCamp(Campinfo camp);
    void delCamp(String campname);
    void updateCamp(Campinfo camp);
    int countCampInfo();
    boolean erALifi();
}