package is.hi.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * TravelPlan klasi sem inniheldur upplýsingar um travelplan
 */
@Entity
@Table (name = "travelplan")
public class TravelPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String travelplanname;
    Date datearrive;
    Date datedepart;
    int totalprice;
    int totalsum;
    int totalnights;

    String username; //TODO skoða
    public TravelPlan(String travelplanname, Date datearrive, Date datedepart, int totalprice, int totalsum, int totalnights, String username){
        this.travelplanname = travelplanname;
        this.datearrive = datearrive;
        this.datedepart = datedepart;
        this.totalprice = totalprice;
        this.totalsum = totalsum;
        this.totalnights = totalnights;
        this.username = username;
    }

    public TravelPlan() {
    }

    public String getTravelplanname() {
        return travelplanname;
    }

    public void setTravelplanname(String travelPlanName) {
        this.travelplanname = travelPlanName;
    }

    public Date getDatearrive() {
        return datearrive;
    }

    public void setDatearrive(Date dateArrive) {
        this.datearrive = dateArrive;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date dateDepart) {
        this.datedepart = dateDepart;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalPrice) {
        this.totalprice = totalPrice;
    }

    public int getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(int totalSum) {
        this.totalsum = totalSum;
    }

    public int getTotalnights() {
        return totalnights;
    }

    public void setTotalnights(int totalNights) {
        this.totalnights = totalNights;
    }
}
