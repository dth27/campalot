package is.hi.repository;

import is.hi.model.Traveller;

import java.util.List;

/**
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * @author Diljá, Ólöf, Sandra, Kristín
 *
 * repository for all travellers
 */
public interface travellerRepository {
    /**
     * retrieves all travellers
     * @return list of travellers
     */
    List <Traveller> getAll();

    /**
     * adds traveller
     * @param traveller
     */
    void add(Traveller traveller);
}
