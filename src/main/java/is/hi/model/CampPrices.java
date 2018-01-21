package is.hi.model;

import javax.persistence.*;

@Entity
@Table(name="campsiteprices")
public class CampPrices {

    int normalprice;
    int childrenprice;
    int otherprice;
    int electricity;
    String normaldescr;
    String childrendescr;
    @Id
    String campname;

    public CampPrices(int normalprice, int childrenprice, int otherprice, int electricity, String normaldescr, String childrendescr, String campname) {
        this.normalprice = normalprice;
        this.childrenprice = childrenprice;
        this.otherprice = otherprice;
        this.electricity = electricity;
        this.normaldescr = normaldescr;
        this.childrendescr = childrendescr;
        this.campname = campname;
    }
    public CampPrices(){

    }

    public int getNormalprice() {
        return normalprice;
    }

    public void setNormalprice(int normalprice) {
        this.normalprice = normalprice;
    }

    public int getChildrenprice() {
        return childrenprice;
    }

    public void setChildrenprice(int childrenprice) {
        this.childrenprice = childrenprice;
    }

    public int getOtherprice() {
        return otherprice;
    }

    public void setOtherprice(int otherprice) {
        this.otherprice = otherprice;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public String getNormaldescr() {
        return normaldescr;
    }

    public void setNormaldescr(String normaldescr) {
        this.normaldescr = normaldescr;
    }

    public String getChildrendescr() {
        return childrendescr;
    }

    public void setChildrendescr(String childrendescr) {
        this.childrendescr = childrendescr;
    }

    public String getCampname() {
        return campname;
    }

    public void setCampname(String campname) {
        this.campname = campname;
    }
}

