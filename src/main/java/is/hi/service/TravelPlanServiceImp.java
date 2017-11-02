package is.hi.service;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;
import is.hi.repository.travelPlanItemRepository;
import is.hi.repository.travelPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class TravelPlanServiceImp implements TravelPlanService {

    @Qualifier("travelPlanRepository")
    @Autowired
    travelPlanRepository planRep;
    @Autowired
    travelPlanItemRepository planItemRep;

    private ArrayList<TravelPlan> listofTravelPlans;
    private ArrayList<TravelPlanItem> listofTravelPlanitems;
    private ArrayList<TravelPlan> userList;

    @Override
    public ArrayList getTravelplans() {

        listofTravelPlans = (ArrayList<TravelPlan>) planRep.getAll();
        return listofTravelPlans;
    }

    @Override
    public ArrayList getUserTravelplan(String user) {
        ArrayList<TravelPlan> travelplans = new ArrayList<TravelPlan>();
        ArrayList<TravelPlan> selectedTravelPlans = new ArrayList<TravelPlan>();
        travelplans = (ArrayList<TravelPlan>) planRep.getAll();
        for (TravelPlan t : travelplans) {
            if (t.getUsername().equals(user)) {
                selectedTravelPlans.add(t);
            }
        }
        return selectedTravelPlans;
    }

    /**
     * @return a list of all travelplan items
     */
    @Override
    public ArrayList getTravelplanItems() {
        listofTravelPlanitems = (ArrayList<TravelPlanItem>) planItemRep.getAll();
        return listofTravelPlanitems;
    }

    /**
     * Creates a new Travel plan
     *
     * @param planName
     * @param username
     */
    @Override
    public void createTravelplan(String planName, String username) {
        TravelPlan travelplan = new TravelPlan(planName, username);
        add(travelplan);
    }

    /**
     * adds Travelplanitem to the list
     *
     * @param travelplanitem
     */
    @Override
    public void addTravelplanItem(TravelPlanItem travelplanitem) {
        listofTravelPlanitems.add(travelplanitem);
    }

    /**
     * adds travelplan to a list
     *
     * @param travelplan
     */
    @Override
    public void add(TravelPlan travelplan) {
        planRep.addTravelPlan(travelplan.getTravelplanname(), travelplan.getUsername());
    }

    /**
     * Adds an item to a travelplan
     *
     * @param travelplan
     * @param travelplanitem
     */
    @Override
    public void addItemtoPlan(String travelplan, TravelPlanItem travelplanitem) {
        String planName = travelplan;
        Date campname = travelplanitem.getDatearrive();
        Date Datedepart = travelplanitem.getDatedepart();
        String user = travelplanitem.getUsername();
        long diff = travelplanitem.getDatedepart().getTime() - travelplanitem.getDatearrive().getTime();
        float days = (diff / (1000 * 60 * 60 * 24));
        int totaldays = Math.round(days);
        int price = travelplanitem.getTotalprice() * totaldays;
        System.out.println(days);
        //long totalprice = travelplanitem.getTotalprice()*diff;
        planItemRep.addItem(travelplan, travelplanitem.getCampname(), travelplanitem.getDatearrive(), travelplanitem.getDatedepart(), price, user);
    }

    @Override
    public ArrayList getOneTravelPlan(String travelplanname, String user) {
        TravelPlan travelplan = new TravelPlan();
        try {
            //listofTravelPlans = (ArrayList<TravelPlan>) planRep.getOnePlan(travelplanname,user);
            listofTravelPlans = (ArrayList<TravelPlan>) planRep.findTravelPlanByTravelplannameAndUsername(travelplanname, user);
            travelplan = listofTravelPlans.get(0);

            System.out.println(travelplan.getTravelplanname());
            listofTravelPlanitems = (ArrayList<TravelPlanItem>) planItemRep.findByTravelplannameAndUsername(travelplanname, user);
        }catch (Exception e){
            System.out.println(e);
        }
        return listofTravelPlanitems;
    }

    @Override
    public ArrayList getOneTravelPlanItems(String travelplanname, String user) {
        return null;
    }

    @Override
    public ArrayList getOneUserItems(TravelPlan travelplan) {
        String travelplanname = travelplan.getTravelplanname();
        String user = travelplan.getUsername();
        try {
            //listofTravelPlanitems = (ArrayList<TravelPlanItem>) planItemRep.getUserItems(travelplanname, user);
            listofTravelPlanitems = (ArrayList<TravelPlanItem>) planItemRep.findByTravelplannameAndUsername(travelplanname, user);
        }catch (Exception e){
            System.out.println("GetOneUserItems " + e);
        }
        return listofTravelPlanitems;
    }

    @Override
    public ArrayList getAllUserItems(ArrayList listofplans) {
        return null;

    }

    @Override
    public TravelPlan onePlan(String travelname, String user){
        listofTravelPlans = (ArrayList<TravelPlan>) planRep.findTravelPlanByTravelplannameAndUsername(travelname, user);
        TravelPlan travel = listofTravelPlans.get(0);
        return travel;
    }
}

