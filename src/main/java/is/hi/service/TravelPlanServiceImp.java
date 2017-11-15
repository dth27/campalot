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

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Tekur við skipunum frá controller til að notandi geti
 * búið til nýtt travel plan, nýtt travelplanitem og bætt því í travel plan sitt
 */
@Service
public class TravelPlanServiceImp implements TravelPlanService {

    @Qualifier("travelPlanRepository")
    @Autowired
    travelPlanRepository planRep;
    @Autowired
    travelPlanItemRepository planItemRep;

    /**
     * An ArrayList of all the TravelPlans that have been created
     */
    private ArrayList<TravelPlan> listofTravelPlans;

    /**
     * An ArrayList of all the TravelPlanItems created
     */
    private ArrayList<TravelPlanItem> listofTravelPlanitems;




    /**
     * Finds all the TravelPlans that have been created (and are in the database)
     * @return      an ArrayList of all the TravelPlans
     */
    @Override
    public ArrayList getTravelplans(){
        listofTravelPlans = (ArrayList<TravelPlan>) planRep.getAll();
        return listofTravelPlans;
    }
    @Override
    public ArrayList getUserTravelplans(String plan, String user){
        listofTravelPlans = (ArrayList<TravelPlan>) planRep.findTravelPlanByTravelplannameAndUsername(plan, user);
        return listofTravelPlans;
    }

    @Override
    public void deleteTraveplan(String travelplan, String user){
        planRep.deleteTravelPlan(travelplan, user);
        planItemRep.deleteTravel(travelplan,user);
    }

    /**
     * Finds all the TravelPlans that a certain user has created
     * @param user  the user that is logged in
     * @return      an ArrayList of the user's TravelPlans
     */
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

     * Finds all the TravelPlanItems created
     * @return a list of all travelplanItems created
     */
    @Override
    public ArrayList getTravelplanItems() {
        listofTravelPlanitems = (ArrayList<TravelPlanItem>) planItemRep.getAll();
        return listofTravelPlanitems;
    }

    /**

     * Creates a new Travel Plan
     * @param planName  new Travel Plan name
     * @param username  name of user who created/owns the Travel Plan
     */
    @Override
    public void createTravelplan(String planName, String username) {
        TravelPlan travelplan = new TravelPlan(planName, username);
        add(travelplan);
    }

    /**
     * Adds a Travelplanitem to the Arraylist listofTravelPlanitems
     * @param travelplanitem    A single Travel Plan Item Object
     */
    @Override
    public void addTravelplanItem(TravelPlanItem travelplanitem) {
        listofTravelPlanitems.add(travelplanitem);
    }

    /**
     * Adds a TravelPlan to the database
     * @param travelplan        A single Travel Plan Object
     */
    @Override
    public void add(TravelPlan travelplan) {
        planRep.addTravelPlan(travelplan.getTravelplanname(), travelplan.getUsername());
    }

    /**
     * Adds a TravelPlanItem to a TravelPlan
     * @param travelplan        A single Travel Plan Object
     * @param travelplanitem    A single Travel Plan Item Object
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

