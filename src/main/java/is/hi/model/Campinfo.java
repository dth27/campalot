package is.hi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO-Dilja move price from description into an int variable

@Entity
@Table (name = "campsitebigdata")
public class Campinfo {
    @Id
    String campname;
    String campaddress;
    String campzip;
    String campemail;
    String campphone;
    String campwebsite;
    String campseason;
    String maincategory;
    String category;
    String region;
    String description;
    int xval;
    int yval;

    public Campinfo(){

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

    public void setCampaddress(String campaddres) {
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
}
