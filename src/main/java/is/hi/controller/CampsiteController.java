package is.hi.controller;


import com.sun.org.apache.regexp.internal.RE;
import is.hi.model.CampAmenities;
import is.hi.model.Campsites;
import is.hi.service.campSiteService;
import is.hi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * @author Dilja Thorkelsdottir
 * @date december 2017
 *
 * A controller that receives commands from web interface
 * Allows user to see campsites, filter them, etc.
 * Allows admin users to create new, update, delete their camps
 */

@Controller
public class CampsiteController {
    @Autowired
    campSiteService campservice;
    @Autowired
    UserService userservice;

    @RequestMapping(value="listofcamps", method= RequestMethod.GET)
    public String showCamps(Model model){
        ArrayList<Campsites> Campsites;
        Campsites = campservice.getCampinfo();

        model.addAttribute("campsites", Campsites);
        return "/allcampsites";
    }
    @RequestMapping(value="browsecampsites", method= RequestMethod.GET)
    public String browse(Model model) {
        ArrayList<Campsites> Campsites;
        Campsites = campservice.getCampinfo();
        model.addAttribute("campsites", Campsites);
        //check user logged in
        //get campsites and so on
        //suggestions thing

        return "/allcampsites";
    }
    @RequestMapping(value="more", method = RequestMethod.GET)
    public String getMore(@RequestParam(value = "campname") String campName, Model model){
        //na i sidu og uppsetning

        ArrayList<CampAmenities> amenities = campservice.getAmenities(campName);
        model.addAttribute("Campname", campName);
        //TODO paeling að senda listan eitthvert annað til að vinna úr
        //hvað er í honum... það einhvernvegin er
        model.addAttribute("amenities", amenities);
        return "/campinfo";
    }


}
