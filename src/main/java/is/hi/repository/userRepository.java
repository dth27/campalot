package is.hi.repository;

import is.hi.model.userAccess;

import java.util.List;
import is.hi.model.userAccess;
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
<<<<<<< HEAD
 * repository for all travellers
 */

public interface userRepository extends JpaRepository<userAccess, String> {
    /**
     * retrieves all travellers
     * @return list of travellers
     */
    @Query(value ="SELECT a FROM userAccess a")
    List<userAccess> getAll();


    /**
     * adds userAccess
     * @param userAccess
     */
    //void add(userAccess userAccess);
    //String getReviews(String username);


}
