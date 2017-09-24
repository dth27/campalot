package is.hi.service;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;
import is.hi.repository.travelPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TravelPlanServiceImp implements TravelPlanService{

    @Autowired
    travelPlanRepository planRep;

    private ArrayList<TravelPlan> listofTravelPlans;

    @Override
    public ArrayList getTravelplans(){
        try{
        listofTravelPlans = (ArrayList<TravelPlan>) planRep.getAll();
        return listofTravelPlans;} catch (Exception e){
            System.out.print("j");
        }
        return null;

    }
    @Override
    public void createTravelplan(String planName, String username){
        TravelPlan travelplan = new TravelPlan(planName, null,null,0,0,0, username);
        planRep.add(travelplan);
    }
    @Override
    public void addTravelplanItem(TravelPlanItem travelplanitem){
       // travelplanitem.setDateArrive(null);

    }
    @Override
    public void add(TravelPlan travelplan){
        listofTravelPlans.add(travelplan);
    }

}
