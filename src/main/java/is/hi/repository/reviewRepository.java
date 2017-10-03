package is.hi.repository;

import is.hi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface reviewRepository extends JpaRepository<Review, Long> {

    /**
     * retrieves all Reviews
     * @return list of Reviews
     */

        @Query(value = "SELECT id, review, review.rating FROM review", nativeQuery = true)
        ArrayList<Review> getAll();



}
