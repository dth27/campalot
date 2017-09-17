package is.hi.model;

import java.util.Date;

public class TravelPlan {
    String travelPlanName;
    Date dateArrive;
    Date dateDepart;
    int totalPrice;
    int totalSum;
    int totalNights;

    public String getTravelPlanName() {
        return travelPlanName;
    }

    public void setTravelPlanName(String travelPlanName) {
        this.travelPlanName = travelPlanName;
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

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public int getTotalNights() {
        return totalNights;
    }

    public void setTotalNights(int totalNights) {
        this.totalNights = totalNights;
    }
}
