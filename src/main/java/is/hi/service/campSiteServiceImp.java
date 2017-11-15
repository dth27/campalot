package is.hi.service;


import is.hi.model.Campinfo;
import is.hi.repository.campinfoRepository;
import is.hi.repository.reviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;


/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Service class for the campsites
 */

/**
 *
 */
@Service
public class campSiteServiceImp implements campSiteService {

    @Autowired
    campinfoRepository campInfoRep;
    @Autowired
    reviewRepository revRep;


    private ArrayList<Campinfo> BList;


    /**
     * Counts how many campsites we have in our database
     * @return
     */
    @Override
    public int countCampInfo(){
        int count = 0;
        BList = (ArrayList<Campinfo>) campInfoRep.getAll();
        for(Campinfo camp : BList){
            count = count + 1 ;
        }
        return count;
    }

    /**
     * Gets one camp from database
     * @param name name of the camp
     * @return returns the camp
     */
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

    /**
     * Fetches all the campsites in the database
     * @return Arraylist of all campsites
     */
    @Override
    public  ArrayList getCampinfo(){
        BList = (ArrayList<Campinfo>) campInfoRep.getAll();
        return BList;
    }

    /**
     * Checks if certain campname exists
     * @param campname - name of the camp
     * @return true if exists, false otherwise
     */
    @Override
    public boolean doesCampExist(String campname) {
        BList = (ArrayList<Campinfo>) campInfoRep.getAll();
        for (Campinfo t : BList) {
            if (campname.equals(t.getCampname())){
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new camp into table campsitebigdata
     * @param camp - the new camp
     */
    @Override
    public void addNewCamp(Campinfo camp) {
        campInfoRep.addCamp(camp.getCampname(), camp.getCampaddress(), camp.getCampzip(), camp.getCampemail(), camp.getCampphone(), camp.getCampwebsite(), camp.getCampseason(), camp.getMaincategory(), camp.getCategory(), camp.getRegion(), camp.getDescription(), camp.getXval(), camp.getYval(), camp.getPrice());
    }

    /**
     * //Deletes camp in the table campsitebigdata
     * @param campname - name of the campsite
     */
    @Override
    public void delCamp(String campname) {
        campInfoRep.deleteCamp(campname);
    }


    /**
     * Adds a new camp into table campsitebigdata
     * @param camp
     */
    @Override
    public void updateCamp(Campinfo camp) {
        campInfoRep.updateCamp(camp.getCampname(), camp.getCampaddress(), camp.getCampzip(), camp.getCampemail(), camp.getCampphone(), camp.getCampwebsite(), camp.getCampseason(), camp.getMaincategory(), camp.getCategory(), camp.getRegion(), camp.getDescription(), camp.getXval(), camp.getYval(), camp.getPrice());
    }


    //Dæmi fyrir test á mockup hvort að þjónustan sé "á lífi"
    @Override
    public boolean erALifi() {return true;}

}