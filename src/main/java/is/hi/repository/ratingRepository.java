package is.hi.repository;

import is.hi.model.AverageRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface ratingRepository extends JpaRepository <AverageRating, Long> {

    /**
     * retrieves all Ratings
     * @return list of Ratings
     */

    @Query(value = "SELECT n FROM AverageRating n")
    ArrayList<AverageRating> getAll();

    @Transactional
    @Modifying
    @Query(value = "insert into rating (username, rating, campname) VALUES (?1, ?2, ?3)"
            , nativeQuery = true)
    void addRating(String user, int myRating, String name);

    @Transactional
    @Modifying
    @Query(value = "update campsitebigdata SET averagerating = ?1 WHERE campname = ?2"
            , nativeQuery = true)
    void setAvRating(double r, String campname);
}
