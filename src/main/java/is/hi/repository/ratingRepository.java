package is.hi.repository;

import is.hi.model.AverageRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Rating Repository class that holds all the ratings
 */

@Repository
public interface ratingRepository extends JpaRepository <AverageRating, Long> {

    /**
     * retrieves all Ratings
     * @return list of Ratings
     */

    @Query(value = "SELECT n FROM AverageRating n")
    ArrayList<AverageRating> getAll();

    /**
     * Inserts new rating into database
     * @param user - name of user
     * @param myRating - the rating
     * @param name - the campname
     */
    @Transactional
    @Modifying
    @Query(value = "insert into rating (username, rating, campname) VALUES (?1, ?2, ?3)"
            , nativeQuery = true)
    void addRating(String user, int myRating, String name);

    /**
     * updates rating for a camp
     * @param r rating
     * @param campname - campname
     */
    @Transactional
    @Modifying
    @Query(value = "update campsitebigdata SET averagerating = ?1 WHERE campname = ?2"
            , nativeQuery = true)
    void setAvRating(double r, String campname);
}
