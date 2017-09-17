package is.hi.controller;

import is.hi.model.*;
import is.hi.repository.*;
import is.hi.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/listCamps", method = RequestMethod.GET)
    public String listCamps(Model model){
        ArrayList<Camp> List;
        List = (ArrayList<Camp>) campRep.getAll();
        model.addAttribute("Camps", List);
        return "campsites/allCampsites";
    }

}
