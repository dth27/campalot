package is.hi.service;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


public interface TravelPlanService {

    ArrayList getTravelplans();
    ArrayList getUserTravelplans(String plan, String user);
    ArrayList getTravelplanItems();
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
