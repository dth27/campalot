package is.hi.controller;

import com.sun.org.apache.regexp.internal.RE;
import is.hi.model.*;
import is.hi.repository.*;
import is.hi.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/campsites")
public class showCampController {
    @Autowired
    campSiteService tjaldService;

    @Autowired
    campsiteRepository campRep;

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
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String synaNotanda(Model model){
        ArrayList<Camp> cList;
        cList = (ArrayList<Camp>) campRep.getAll();
        model.addAttribute("camps", cList);
        return "campsites/notendasida";
    }
    @RequestMapping(value="/addToPlan", method = RequestMethod.GET)
    public String addToPlan(Model model){
        //ArrayList<travelPlan> tList;

        //model.addAttribute("camps", tList);
        return "campsites/notendasida";
    }
    /*@RequestMapping(value="/save", method = RequestMethod.POST)
    public String handlePost(@RequestParam String action){
        return "save";
    }*/

    //@RequestParam(value = "/travelPlan", meth)
}
