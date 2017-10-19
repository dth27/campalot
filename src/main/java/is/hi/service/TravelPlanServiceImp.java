package is.hi.service;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;
import is.hi.repository.travelPlanItemRepository;
import is.hi.repository.travelPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TravelPlanServiceImp implements TravelPlanService{

    @Qualifier("travelPlanRepository")
    @Autowired
    travelPlanRepository planRep;
    @Autowired
    travelPlanItemRepository planItemRep;

    private ArrayList<TravelPlan> listofTravelPlans;
    private ArrayList<TravelPlanItem> listofTravelPlanitems;

    @Override
    public ArrayList getTravelplans(){

        listofTravelPlans = (ArrayList<TravelPlan>) planRep.getAll();
        return listofTravelPlans;
    }

    /**
     *
     * @return a list of all travelplan items
     */
    @Override
    public ArrayList getTravelplanItems(){
        listofTravelPlanitems = (ArrayList<TravelPlanItem>) planItemRep.getAll();
        return listofTravelPlanitems;
    }

    /**
     * Creates a new Travel plan
     * @param planName
     * @param username
     */
    @Override
    public void createTravelplan(String planName, String username){
        TravelPlan travelplan = new TravelPlan(planName, username);
        add(travelplan);
    }

    /**
     * adds Travelplanitem to the list
     * @param travelplanitem
     */
    @Override
    public void addTravelplanItem(TravelPlanItem travelplanitem){
        listofTravelPlanitems.add(travelplanitem);
    }

    /**
     * adds travelplan to a list
     * @param travelplan
     */
    @Override
    public void add(TravelPlan travelplan){
        planRep.addTravelPlan(travelplan.getTravelplanname(), travelplan.getUsername());
    }

    /**
     * Adds an item to a travelplan
     * @param travelplan
     * @param travelplanitem
     */
    @Override
    public void addItemtoPlan(String travelplan, TravelPlanItem travelplanitem){
        //planRep.addItem(travelplan, travelplanitem);
    }

}
