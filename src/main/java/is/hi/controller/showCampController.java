package is.hi.controller;

import is.hi.model.*;
import is.hi.repository.*;
import is.hi.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

import java.util.ArrayList;

@Controller
@RequestMapping("/campsites")
public class showCampController {
    @Autowired
    campSiteService tjaldService;

    @Autowired
    campsiteRepository campRep;
    @Autowired
    travelPlanRepository travelPlanRep;
    @Autowired
    travellerRepository travellerRep;

    ArrayList<TravelPlan> tpList;
    ArrayList<Traveller> tList;

    @RequestMapping("/forsida")
    public String forsida(){
        return "campsites/forsida";
    }

    @RequestMapping(value = "/listofcamps", method = RequestMethod.GET)
    public String listCamps(Model model) {
        ArrayList<Camp> cList;
        cList = (ArrayList<Camp>) campRep.getAll();
        model.addAttribute("camps", cList);
        return "campsites/allCampsites";
    }

    @RequestMapping("/addTravel")
    public String addTravel(Model model){


        tpList = (ArrayList<TravelPlan>) travelPlanRep.getAll();
        model.addAttribute("travelplans", tpList);

        return "campsites/addTravel";
    }
    @RequestMapping("/newAccountSite")
    public String newAccountSite(){
        return "campsites/newAccountSite";
    }

    @RequestMapping("newTravelPlan")
    public String newTravelPlan(){
        return "campsites/newTravelPlan";
    }

    @RequestMapping(value = "/newTravel", method = RequestMethod.POST)
    public String newTravel(@RequestParam(value="username")
                                    String username, @RequestParam(value="planName") String planName, Model model)
    {
        TravelPlan travelplan = new TravelPlan(planName , null, null, 0, 0, 0, username);

        tpList.add(travelplan);
        model.addAttribute("travelplans", tpList);
        return "campsites/addTravel";

    }

    @RequestMapping("/accountInfo")
    public String accountInfo(){
        return "campsites/accountInfo";
    }

    @RequestMapping(value = "/newAccount", method = RequestMethod.POST)
    public String newAccount(@RequestParam(value="username")
                                    String username, @RequestParam(value="email") String email,
                                    @RequestParam(value="pw1") String pw1,
                                    @RequestParam(value="pw2") String pw2)
    {
        tList = (ArrayList<Traveller>) travellerRep.getAll();
        for(Traveller t: tList){
            if (username.equals(t.getUsername())||email.equals(t.getEmail()))
                return "campsites/newAccountSite";
        }

        if(pw1.equals(pw2)){
            Traveller traveller = new Traveller(username, email, pw1);
            tList.add(traveller);
            return "campsites/accountInfo";
        }
        return "campsites/newAccount";
    }


    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String synaNotanda(@RequestParam(value="uname") String uname , @RequestParam(value="psw") String psw,
                                Model model){


        tList = (ArrayList<Traveller>) travellerRep.getAll();
        Boolean login = false;

        for (Traveller t: tList){
            if(psw.equals(t.getPassword())&&uname.equals(t.getUsername()))
                login = true;
        }

        if(login==true)
        {  ArrayList<Camp> cList;
        cList = (ArrayList<Camp>) campRep.getAll();
        model.addAttribute("camps", cList);

        ArrayList<TravelPlan> tpList;
        tpList = (ArrayList<TravelPlan>) travelPlanRep.getAll();
        model.addAttribute("travelplans", tpList);
            return "campsites/notendasida";}
        else
            return "campsites/forsida";

    }
}
