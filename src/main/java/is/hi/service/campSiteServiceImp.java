package is.hi.service;


import is.hi.model.CampAmenities;
import is.hi.model.Campinfo;
import is.hi.model.Campsites;
import is.hi.repository.campamenitiesRepository;
import is.hi.repository.campinfoRepository;
import is.hi.repository.reviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;


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
    @Autowired
    campamenitiesRepository amenRep;

    private ArrayList<Campsites> BList;


    /**
     * Counts how many campsites we have in our database
     * @return
     */
    @Override
    public int countCampInfo(){
        int count = 0;
        BList = (ArrayList<Campsites>) campInfoRep.getAll();
        for(Campsites camp : BList){
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
    public Campsites getOneCampinfo(String name){
        BList = (ArrayList<Campsites>) campInfoRep.getAll();
        Campsites camp1 = null;
        for (Campsites camp : BList){
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
        BList = (ArrayList<Campsites>) campInfoRep.getAll();
        return BList;
    }

    /**
     * Checks if certain campname exists
     * @param campname - name of the camp
     * @return true if exists, false otherwise
     */
    @Override
    public boolean doesCampExist(String campname) {
        BList = (ArrayList<Campsites>) campInfoRep.getAll();
        for (Campsites t : BList) {
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
    public void addNewCamp(Campsites camp) {
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
    public void updateCamp(Campsites camp) {
        campInfoRep.updateCamp(camp.getCampname(), camp.getCampaddress(), camp.getCampzip(), camp.getCampemail(), camp.getCampphone(), camp.getCampwebsite(), camp.getCampseason(), camp.getMaincategory(), camp.getCategory(), camp.getRegion(), camp.getDescription(), camp.getXval(), camp.getYval(), camp.getPrice());
    }

    @Override
    public ArrayList getAmenities(String campname){
        List<CampAmenities> amenities;
        amenities = amenRep.findAllByCampname(campname);
        /*List<String> truAm = null;
        for (CampAmenities camp: amenities) {
            if (camp.getCampingground()){
                truAm.add("campingground.jpg");
            }
            if (camp.getCoffeeshop()){
                truAm.add("coffeeshop.jpg");
            }
            if (camp.getConferenceroom()){
                truAm.add("conferenceroom.jpg");
            }
            if (camp.getCookingarea()){
                truAm.add("cookingarea.jpg");
            }
            if (camp.getCookingfacility()){
                truAm.add("cookingfacility.jpg");
            }
            if (camp.getCottagerental()){
                truAm.add("cottagerental.jpg");
            }
            if (camp.getElectricity()){
                truAm.add("electricity.jpg");
            }
            if (camp.getFreewifi()){
                truAm.add("freewifi.jpg");
            }
            if (camp.getHorseriding()){
                truAm.add("horseriding.jpg");
            }
            if (camp.getHotpot()){
                truAm.add("hotpot.jpg");
            }
            if (camp.getInternet()){
                truAm.add("internet.jpg");
            }
            if (camp.getLaundry()){
                truAm.add("laundry.jpg");
            }
            if (camp.getRestaurant()){
                truAm.add("restaurant.jpg");
            }
            if (camp.getShower()){
                truAm.add("shower.jpg");
            }
            if (camp.getSleepingbag()){
                truAm.add("sleepingbag.jpg");
            }
            if (camp.getWalkingpath()){
                truAm.add("walkingpath.jpg");
            }
            if (camp.getWastetank()){
                truAm.add("wastetank.jpg");
            }
            if (camp.getWheelchair()){
                truAm.add("wheelchair.jpg");
            }
        }*/
        return (ArrayList) amenities;
    }


    //Dæmi fyrir test á mockup hvort að þjónustan sé "á lífi"
    @Override
    public boolean erALifi() {return true;}

}