package is.hi.repository;

import is.hi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
public interface reviewRepository extends JpaRepository<Review, Long> {

    /**
     * retrieves all Reviews
     * @return list of Reviews
     */

        @Query(value = "SELECT n FROM Review n")
        ArrayList<Review> getAll();

    @Transactional
    @Modifying
    @Query(value = "insert into review(review,campname,username) VALUES (?1, ?2, ?3)"
            , nativeQuery = true)
    void addReview(String myReview, String name, String user);
}
