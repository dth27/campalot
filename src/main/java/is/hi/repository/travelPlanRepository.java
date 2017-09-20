package is.hi.repository;

import is.hi.model.TravelPlan;

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

    /**
     * adds travelplan
     * @param travelplan
     */
    void add(TravelPlan travelplan);

}
