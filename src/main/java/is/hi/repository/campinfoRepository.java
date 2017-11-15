package is.hi.repository;

import is.hi.model.Campinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * campinfoRepository class for campsites
 */

public interface campinfoRepository extends JpaRepository<Campinfo, Long>{

    /**
     * Get all campinfo
     */
    @Query(value = "SELECT n FROM Campinfo n")
    List<Campinfo> getAll();


    /**
     * Adds a new campsite to database
     * @param name - name of camp
     * @param address - address of camp
     * @param zip - zip code of camp
     * @param email - email of camp
     * @param phone - phone number of camp
     * @param website - website of camp
     * @param season - What seasons is the camp open
     * @param mainCategory - catagory
     * @param campCategory - catagory
     * @param campRegion - region of the cmap
     * @param descript - description of the cmap
     * @param xVal - x coordinates
     * @param yVal - y coordinates
     */
    @Transactional
    @Modifying
    @Query(value = "insert into campsitebigdata (campname, campaddress, campzip, campemail, campphone, campwebsite, campseason, maincategory, category, region, description, xval, yval) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13)"
            , nativeQuery = true)
    void addCamp(String name, String address, String zip, String email, String phone, String website, String season, String mainCategory, String campCategory, String campRegion, String descript, int xVal, int yVal);

    /**
     * delets campsite from database
     * @param name - name of the camp
     */
    @Transactional
    @Modifying
    @Query(value = "delete from campsitebigdata where campname=?1"
            , nativeQuery = true)
    void deleteCamp(String name);

    /**
     * Updates information about campsite
     * @param name - name
     * @param address - address
     * @param zip - zip code
     * @param email - email
     * @param phone - phone
     * @param website - website
     * @param season - season
     * @param mainCategory - main category
     * @param campCategory - camp category
     * @param campRegion - region
     * @param descript - description
     * @param xVal - x coordinates
     * @param yVal - y coordinates
     */
    @Transactional
    @Modifying
    @Query(value = "update campsitebigdata SET campname = ?1, campaddress = ?2, campzip = ?3, campemail = ?4, campphone = ?5, campwebsite = ?6, campseason = ?7, maincategory = ?8, category = ?9, region = ?10, description = ?11, xval = ?12, yval = ?13 WHERE campname = ?1"
            , nativeQuery = true)
    void updateCamp(String name, String address, String zip, String email, String phone, String website, String season, String mainCategory, String campCategory, String campRegion, String descript, int xVal, int yVal);


}
