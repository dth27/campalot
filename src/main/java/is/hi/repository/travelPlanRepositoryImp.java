package is.hi.repository;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;
import is.hi.service.AlternativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Collection of travelplans
 */
@Repository
public class travelPlanRepositoryImp implements travelPlanRepository {


    private final List<TravelPlan> travelplans;
    private final List<TravelPlanItem> travelplanitems;

    // private TravelPlan mockTravelPlan;
    public travelPlanRepositoryImp(){
        this.travelplanitems = new ArrayList<TravelPlanItem>();
        this.travelplans = new ArrayList<TravelPlan>();
        TravelPlan travelplan = new TravelPlan("Ferðalag 1" , null, null, 0, 0, 0, "ofm1");
        travelplans.add(travelplan);
        TravelPlanItem travelplanitem = new TravelPlanItem(null,null, 0,0);
        travelplanitems.add(travelplanitem);


    }

    @Override
    public List<TravelPlan> getAll(){
        return travelplans;
    }
    @Override
    public List<TravelPlanItem> getAllItems(){return travelplanitems;}
    @Override
    public void add (TravelPlan travelplan){
        travelplans.add(travelplan);
    }
    @Override
    public void addItem(String travelplanname, TravelPlanItem travelplanitem){
      TravelPlan travelplan = find(travelplanname);
      travelplan.setDateArrive(travelplanitem.getDateArrive());
      travelplan.setDateDepart(travelplanitem.getDateDepart());
      travelplan.setTotalNights(travelplanitem.getTotalNights());
      travelplan.setTotalPrice(travelplanitem.getTotalPrice());
      add(travelplan);

    }
    @Override
    public void addtoList(TravelPlanItem travelplanitem){
        travelplanitems.add(travelplanitem);
    }

    @Override
    public TravelPlan find(String name){
        TravelPlan travelplan = new TravelPlan("Ferðalag 1" , null, null, 0, 0, 0, "ofm1");
        for (int i = 0; i<travelplans.size(); i++){
            if (travelplans.get(i).getTravelPlanName().equals(name))
                travelplan = travelplans.get(i);
                break;

        }
        return travelplan;
    }

}
