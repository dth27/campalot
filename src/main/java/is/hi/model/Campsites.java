package is.hi.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Campinfo class that holds information of all the campsites
 */

@Entity
@Table (name = "campsites")
public class Campsites {
    @Id
    @NotNull
    @Size(min = 3, max = 50)
    String campname;
    @Size(min = 3, max = 50)
    String campaddress;
    @Size(min = 3, max = 50)
    String campzip;
    @Email
    @Size(min = 6, max = 50)
    String campemail;
    @Size(min = 7, max = 7)
    String campphone;
    @Size(min = 4, max = 50)
    String campwebsite;
    @Size(max = 50)
    String campseason;
    @Size(max = 100)
    String maincategory;
    @Size(max = 100)
    String category;
    @Size(max = 50)
    String region;
    @Size(min = 3, max = 300)
    String description;
    int xval;
    int yval;
    //double averagerating;
    int price;
    String geom;

    public Campsites() {

    }

    public Campsites(String campname, String campaddress, String campzip, String campemail, String campphone, String campwebsite, String campseason, String maincategory, String category, String region, String description, int xval, int yval, int price, String geom) {
        this.campname = campname;
        this.campaddress = campaddress;
        this.campzip = campzip;
        this.campemail = campemail;
        this.campphone = campphone;
        this.campwebsite = campwebsite;
        this.campseason = campseason;
        this.maincategory = maincategory;
        this.category = category;
        this.region = region;
        this.description = description;
        this.xval = xval;
        this.yval = yval;
        //this.averagerating = averagerating;
        this.price = price;
        this.geom = geom;
    }

    public String getCampname() {
        return campname;
    }

    public void setCampname(String campname) {
        this.campname = campname;
    }

    public String getCampaddress() {
        return campaddress;
    }

    public void setCampaddress(String campaddress) {
        this.campaddress = campaddress;
    }

    public String getCampzip() {
        return campzip;
    }

    public void setCampzip(String campzip) {
        this.campzip = campzip;
    }

    public String getCampemail() {
        return campemail;
    }

    public void setCampemail(String campemail) {
        this.campemail = campemail;
    }

    public String getCampphone() {
        return campphone;
    }

    public void setCampphone(String campphone) {
        this.campphone = campphone;
    }

    public String getCampwebsite() {
        return campwebsite;
    }

    public void setCampwebsite(String campwebsite) {
        this.campwebsite = campwebsite;
    }

    public String getCampseason() {
        return campseason;
    }

    public void setCampseason(String campseason) {
        this.campseason = campseason;
    }

    public String getMaincategory() {
        return maincategory;
    }

    public void setMaincategory(String maincategory) {
        this.maincategory = maincategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getXval() {
        return xval;
    }

    public void setXval(int xval) {
        this.xval = xval;
    }

    public int getYval() {
        return yval;
    }

    public void setYval(int yval) {
        this.yval = yval;
    }

   /* public double getAveragerating() {
        return averagerating;
    }

    public void setAveragerating(double averagerating) {
        this.averagerating = averagerating;
    }*/

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}
