package is.hi.repository;

import is.hi.model.Camp;
import java.util.List;

/**
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * @author Diljá Þorkelsdóttir, Ólöf, Sandra, Kristín
 *
 * repository for all campsites
 */
public interface campsiteRepository {
    /**
     * retrieves all campsites
     * @return list of campsites
     */
    List <Camp> getAll();

    /**
     * adds a camp
     * @param camp
     */
    void add(Camp camp);
}
