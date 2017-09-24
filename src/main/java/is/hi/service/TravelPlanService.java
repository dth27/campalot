package is.hi.service;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


public interface TravelPlanService {

    public ArrayList getTravelplans();
    public void createTravelplan(String planName, String username);
    public void add(TravelPlan travelplan);
    public void addTravelplanItem(TravelPlanItem travelplanitem);

}
