package is.hi.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Entity
@Table (name="campsitefacilities")
public class CampAmenities {

    @Id
    String campname;
    Boolean wastetank, horseriding,
    walkingpath, cottagerental, sleepingbag, campingground,
    cookingarea, cookingfacility, internet, hotpot, shower,
    conferenceroom, coffeeshop, restaurant, freewifi, laundry, wheelchair, electricity;


    public CampAmenities(String campname, Boolean wastetank, Boolean horseriding, Boolean walkingpath, Boolean cottagerental, Boolean sleepingbag, Boolean campingground, Boolean cookingarea, Boolean cookingfacility, Boolean internet, Boolean hottub, Boolean shower, Boolean conferenceroom, Boolean coffeeshop, Boolean restaurant, Boolean freewifi, Boolean laundry, Boolean wheelchair, Boolean electricity) {
        this.campname = campname;
        this.wastetank = wastetank;
        this.horseriding = horseriding;
        this.walkingpath = walkingpath;
        this.cottagerental = cottagerental;
        this.sleepingbag = sleepingbag;
        this.campingground = campingground;
        this.cookingarea = cookingarea;
        this.cookingfacility = cookingfacility;
        this.internet = internet;
        this.hotpot = hottub;
        this.shower = shower;
        this.conferenceroom = conferenceroom;
        this.coffeeshop = coffeeshop;
        this.restaurant = restaurant;
        this.freewifi = freewifi;
        this.laundry = laundry;
        this.wheelchair = wheelchair;
        this.electricity = electricity;
    }
    public CampAmenities(){}

    public String getCampname() {
        return campname;
    }

    public void setCampname(String campname) {
        this.campname = campname;
    }

    public Boolean getWastetank() {
        return wastetank;
    }

    public void setWastetank(Boolean wastetank) {
        this.wastetank = wastetank;
    }

    public Boolean getHorseriding() {
        return horseriding;
    }

    public void setHorseriding(Boolean horseriding) {
        this.horseriding = horseriding;
    }

    public Boolean getWalkingpath() {
        return walkingpath;
    }

    public void setWalkingpath(Boolean walkingpath) {
        this.walkingpath = walkingpath;
    }

    public Boolean getCottagerental() {
        return cottagerental;
    }

    public void setCottagerental(Boolean cottagerental) {
        this.cottagerental = cottagerental;
    }

    public Boolean getSleepingbag() {
        return sleepingbag;
    }

    public void setSleepingbag(Boolean sleepingbag) {
        this.sleepingbag = sleepingbag;
    }

    public Boolean getCampingground() {
        return campingground;
    }

    public void setCampingground(Boolean campingground) {
        this.campingground = campingground;
    }

    public Boolean getCookingarea() {
        return cookingarea;
    }

    public void setCookingarea(Boolean cookingarea) {
        this.cookingarea = cookingarea;
    }

    public Boolean getCookingfacility() {
        return cookingfacility;
    }

    public void setCookingfacility(Boolean cookingfacility) {
        this.cookingfacility = cookingfacility;
    }

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public Boolean getHotpot() {
        return hotpot;
    }

    public void setHotpot(Boolean hotbot) {
        this.hotpot = hotbot;
    }

    public Boolean getShower() {
        return shower;
    }

    public void setShower(Boolean shower) {
        this.shower = shower;
    }

    public Boolean getConferenceroom() {
        return conferenceroom;
    }

    public void setConferenceroom(Boolean conferenceroom) {
        this.conferenceroom = conferenceroom;
    }

    public Boolean getCoffeeshop() {
        return coffeeshop;
    }

    public void setCoffeeshop(Boolean coffeeshop) {
        this.coffeeshop = coffeeshop;
    }

    public Boolean getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Boolean restaurant) {
        this.restaurant = restaurant;
    }

    public Boolean getFreewifi() {
        return freewifi;
    }

    public void setFreewifi(Boolean freewifi) {
        this.freewifi = freewifi;
    }

    public Boolean getLaundry() {
        return laundry;
    }

    public void setLaundry(Boolean laundry) {
        this.laundry = laundry;
    }

    public Boolean getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Boolean wheelchair) {
        this.wheelchair = wheelchair;
    }

    public Boolean getElectricity() {
        return electricity;
    }

    public void setElectricity(Boolean electricity) {
        this.electricity = electricity;
    }
}
