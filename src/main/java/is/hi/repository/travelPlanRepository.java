package is.hi.repository;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;

import java.util.List;

/**
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * @author Diljá Þorkelsdóttir, Ólöf, Sandra, Kristín
 *
 * repository for all travellers
 */
public interface travelPlanRepository {
    /**
     * retrieves all travellers
     * @return list of travellers
     */
    List <TravelPlan> getAll();
    List <TravelPlanItem> getAllItems();

    /**
     * adds travelplan
     * @param travelplan
     */
    void add(TravelPlan travelplan);
    void addItem(String travelplanname, TravelPlanItem travelplanitem);
    void addtoList(TravelPlanItem travelplanitem);
    TravelPlan find(String name);

}
