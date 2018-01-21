package is.hi.controller;

import is.hi.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TravelPlanController {
    @Autowired
    TravelPlanService travservice;

    @RequestMapping(value = "addToPlan", method= RequestMethod.POST)
    public String addToPlan(@RequestParam(value="Campname") String camp, Model model){
        String um = "more?campname=" + camp;

        return "redirect:/"+um;
    }
}
