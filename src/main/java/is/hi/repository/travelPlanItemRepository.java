package is.hi.repository;

import is.hi.model.TravelPlanItem;
import java.util.List;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Repository for travelplanitems
 */

public interface travelPlanItemRepository {
    /**
     * gets all travelplanitems
     * @return a list of travelplanitems
     */
    List<TravelPlanItem> getAll();

    /**
     * Adss travelplanitems
     * @param travelplanItem
     */
    void add(TravelPlanItem travelplanItem);
}
