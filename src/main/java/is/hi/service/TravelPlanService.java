package is.hi.service;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Service class for the campsites
 */

public interface TravelPlanService {

    ArrayList getTravelplans();
    ArrayList getUserTravelplans(String plan, String user);
    ArrayList getTravelplanItems();
    ArrayList getUserTravelplanItems(String user);
    void createTravelplan(String planName, String username);
    void deleteTraveplan(String travelplan, String user);
    void add(TravelPlan travelplan);
    void addTravelplanItem(TravelPlanItem travelplanitem);
    void addItemtoPlan(String travelplan, TravelPlanItem travelplanitem);
    ArrayList getUserTravelplan(String user);
    ArrayList getOneTravelPlan(String travelplanname, String user);
    ArrayList getOneTravelPlanItems(String travelplanname, String user);
    ArrayList getOneUserItems(TravelPlan travelplan);
    ArrayList getAllUserItems(ArrayList listofplans);
    TravelPlan onePlan(String travelname, String user);
}
