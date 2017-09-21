package is.hi.repository;

import is.hi.model.TravelPlanItem;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Collection of travelplanitems
 */
@Repository
public class travelPlanItemRepositoryImp implements travelPlanItemRepository {

    private final List<TravelPlanItem> travelplanItems;
    // private TravelPlan mockTravelPlan;
    public travelPlanItemRepositoryImp(){
        this.travelplanItems = new ArrayList<TravelPlanItem>();
        TravelPlanItem travelplanItem = new TravelPlanItem(null, null, 1000, 5);
        travelplanItems.add(travelplanItem);

    }

    @Override
    public List<TravelPlanItem> getAll(){
        return travelplanItems;
    }
    @Override
    public void add (TravelPlanItem travelplanItem){
        travelplanItems.add(travelplanItem);
    }
}

