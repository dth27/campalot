package is.hi.repository;

import is.hi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Review Repository that holds all the reviews for all the campsites
 */

@Repository
public interface reviewRepository extends JpaRepository<Review, Long> {

    /**
     * retrieves all Reviews
     * @return list of Reviews
     */

        @Query(value = "SELECT n FROM Review n")
        ArrayList<Review> getAll();

    /**
     * Inserts new review into database
     * @param myReview - the review
     * @param name - name of the campsite that the review belongs to
     * @param user - username
     */
    @Transactional
    @Modifying
    @Query(value = "insert into review(review,campname,username) VALUES (?1, ?2, ?3)"
            , nativeQuery = true)
    void addReview(String myReview, String name, String user);
}
