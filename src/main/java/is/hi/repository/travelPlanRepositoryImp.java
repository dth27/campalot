package is.hi.repository;

import is.hi.model.TravelPlan;
import org.springframework.stereotype.Repository;
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
    // private TravelPlan mockTravelPlan;
    public travelPlanRepositoryImp(){
        this.travelplans = new ArrayList<TravelPlan>();
        TravelPlan travelplan = new TravelPlan("Ferðalag 1" , null, null, 0, 0, 0, "ofm1");
        travelplans.add(travelplan);

    }

    @Override
    public List<TravelPlan> getAll(){
        return travelplans;
    }
    @Override
    public void add (TravelPlan travelplan){
        travelplans.add(travelplan);
    }
}
