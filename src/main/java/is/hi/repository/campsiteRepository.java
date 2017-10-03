package is.hi.repository;

import is.hi.model.Camp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * @author Diljá, Ólöf, Sandra, Kristín
 *
 * repository for all campsites
 */
@Repository
public interface campsiteRepository extends JpaRepository<Camp, Long> {
    /**
     * retrieves all campsites
     * @return list of campsites
     */
    @Query(value = "SELECT m FROM Camp m")
    //@Query(nativeQuery = true, value =  "SELECT * FROM campsite")
    List<Camp> getAll();



    /**
     * adds a camp
     * @param camp
     */
   // void add(Camp camp);
}
