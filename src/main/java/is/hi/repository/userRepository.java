package is.hi.repository;

import is.hi.model.userAccess;

import java.util.ArrayList;
import java.util.List;
import is.hi.model.userAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * @author Diljá, Ólöf, Sandra, Kristín
 *
 * repository for all travellers
 */

public interface userRepository extends JpaRepository<userAccess, Long> {
    /**
     * retrieves all travellers
     * @return list of travellers
     */
    @Query(value ="SELECT a FROM userAccess a")
    List<userAccess> getAll();

    @Query(value= "SELECT a FROM userAccess a WHERE a.username =?1")
    List<userAccess> getUserfromname(String username);
    /*@Modifying
    @Query(value="UPDATE Review SET rating ")
    setRating();*/
    //userAccess acc = em.find();



    /**
     * adds userAccess
     *
     */
    @Transactional
    @Modifying
    @Query(value = "insert into useraccess(username,email,password,hasaccess,hasadminauthority) VALUES (?1, ?2, ?3, ?4, ?5)"
            , nativeQuery = true)
    void add(String username, String email, String password, Boolean hasaccess, Boolean hasadminauthority);


    //String getReviews(String username);


}
