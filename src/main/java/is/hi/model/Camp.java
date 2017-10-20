package is.hi.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Camp klasi sem inniheldur upplýsingar um tjaldsvæðin
 */
@Entity
@Table (name="campsite")
public class Camp {
    @Id
    String campname;
    int price;
    String service;
    String openinghours;
    String shops;
    String entertainment;
    String camparea;
    double camplong;
    double camplat;




    public Camp(String campname, int price, String service, String openinghours, String shops, String entertainment, String camparea, double camplong, double camplat) {
        this.campname = campname;
        this.price = price;
        this.service = service;
        this.openinghours = openinghours;
        this.shops = shops;
        this.entertainment = entertainment;
        this.camparea = camparea;
        this.camplong = camplong;
        this.camplat = camplat;
    }

    public Camp() {
    }
   /* @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Review> review = new ArrayList<Review>();
*/

    public String getCampname() {
        return campname;
    }

    public void setCampname(String campName) {
        this.campname = campName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getOpeninghours() {
        return openinghours;
    }

    public void setOpeninghours(String openingHours) {
        this.openinghours = openingHours;
    }

    public String getShops() {
        return shops;
    }

    public void setShops(String shops) {
        this.shops = shops;
    }

    public String getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(String entertainment) {
        this.entertainment = entertainment;
    }

    public String getCamparea() {
        return camparea;
    }

    public void setCamparea(String campArea) {
        this.camparea = campArea;
    }

    public double getCamplong() {
        return camplong;
    }

    public void setCamplong(double campLong) {
        this.camplong = campLong;
    }

    public double getCamplat() {
        return camplat;
    }

    public void setCamplat(double campLat) {
        this.camplat = campLat;
    }

}
