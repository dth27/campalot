package is.hi.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Travelplanitem klasi sem inniheldur upplýsingar um travelplanitems
 */
@Entity
@Table (name = "travelplanitem")
public class TravelPlanItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date datearrive;
    Date datedepart;
    int totalprice;
    int totalnights;

    public TravelPlanItem(int id, Date datearrive, Date datedepart, int totalprice, int totalnights) {
        this.id = id;
        this.datearrive = datearrive;
        this.datedepart = datedepart;
        this.totalprice = totalprice;
        this.totalnights = totalnights;
    }

    public TravelPlanItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTotalnights() {
        return totalnights;
    }

    public void setTotalnights(int totalNights) {
        this.totalnights = totalNights;
    }
}
