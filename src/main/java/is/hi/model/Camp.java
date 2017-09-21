package is.hi.model;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Camp klasi sem inniheldur upplýsingar um tjaldsvæðin
 */

public class Camp {
    String campName;
    int price;
    String service;
    String openingHours;
    String shops;
    String entertainment;
    String campArea;
    double campLong;
    double campLat;

    public Camp(String campName, int price, String service, String openingHours, String shops, String entertainment, String campArea, double campLong, double campLat) {
        this.campName = campName;
        this.price = price;
        this.openingHours = openingHours;
        this.shops = shops;
        this.entertainment = entertainment;
        this.campArea = campArea;
        this.campLong = campLong;
        this.campLat = campLat;
    }
    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
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

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
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

    public String getCampArea() {
        return campArea;
    }

    public void setCampArea(String campArea) {
        this.campArea = campArea;
    }

    public double getCampLong() {
        return campLong;
    }

    public void setCampLong(double campLong) {
        this.campLong = campLong;
    }

    public double getCampLat() {
        return campLat;
    }

    public void setCampLat(double campLat) {
        this.campLat = campLat;
    }
}
