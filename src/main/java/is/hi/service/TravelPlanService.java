package is.hi.service;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


public interface TravelPlanService {

    ArrayList getTravelplans();
    ArrayList getTravelplanItems();
    void createTravelplan(String planName, String username);
    void add(TravelPlan travelplan);
    void addTravelplanItem(TravelPlanItem travelplanitem);
    void addItemtoPlan(String travelplan, TravelPlanItem travelplanitem);

}
