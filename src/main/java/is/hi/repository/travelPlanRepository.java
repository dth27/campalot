package is.hi.repository;

import is.hi.model.TravelPlan;
import is.hi.model.TravelPlanItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * @author Diljá Þorkelsdóttir, Ólöf, Sandra, Kristín
 *
 * repository for all travellers
 */

public interface travelPlanRepository extends JpaRepository<TravelPlan, String> {
    /**
     * retrieves all travellers
     * @return list of travellers
     */
    @Query(value ="SELECT a FROM TravelPlan a")
    List <TravelPlan> getAll();

    @Transactional
    @Modifying
    @Query(value="insert into travelplan(travelplanname, username) VALUES (?1, ?2)", nativeQuery = true)
    void addTravelPlan(String planname, String user);
    /**
     * adds travelplan
     * @param travelplan
     */
   /* TravelPlan save(TravelPlan travelplan);
    void add(TravelPlan travelplan);
    void addItem(String travelplanname, TravelPlanItem travelplanitem);
    void addtoList(TravelPlanItem travelplanitem);
    TravelPlan find(String name);*/

}
