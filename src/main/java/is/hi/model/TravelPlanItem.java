package is.hi.model;

import java.util.Date;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Travelplanitem klasi sem inniheldur upplýsingar um travelplanitems
 */

public class TravelPlanItem {
    Date dateArrive;
    Date dateDepart;
    int totalPrice;
    int totalNights;

    public TravelPlanItem(Date dateArrive, Date dateDepart, int totalPrice, int totalNights) {
        this.dateArrive = dateArrive;
        this.dateDepart = dateDepart;
        this.totalPrice = totalPrice;
        this.totalNights = totalNights;
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalNights() {
        return totalNights;
    }

    public void setTotalNights(int totalNights) {
        this.totalNights = totalNights;
    }
}
