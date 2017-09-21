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
import java.util.Date;

/**
 * TODO-Dilja einn eða fleiri controller? Think about it
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Tekur við skipunum frá vefviðmóti til að notandi geti loggað sig inn
 * búið til nýtt travel plan og bætt í travel planið
 */
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
    @Autowired
    travelPlanItemRepository travelPlanItemRep;

    ArrayList<TravelPlanItem> tpiList;
    ArrayList<TravelPlan> tpList;
    ArrayList<Traveller> tList;

    /**
     * @return skilar forsíðu
     */
    @RequestMapping("/forsida")
    public String forsida(){
        return "campsites/forsida";
    }

    /**
     * TODO setja í service
     * @param model
     * @return vefsíðu sem sýnir lista af öllum tjaldsvæðum
     */
    @RequestMapping(value = "/listofcamps", method = RequestMethod.GET)
    public String listCamps(Model model) {
        ArrayList<Camp> cList;
        cList = (ArrayList<Camp>) campRep.getAll();
        model.addAttribute("camps", cList);
        return "campsites/allCampsites";
    }


    /**
     *
     * @return vefsíðu sem gerir notenda kleift að stofa nýjan aðgang
     */
    @RequestMapping("/newAccountSite")
    public String newAccountSite(){
        return "campsites/newAccountSite";
    }

    /**
     *
     * @return
     */

    @RequestMapping("/accountInfo")
    public String accountInfo(){
        return "campsites/accountInfo";
    }

    /**
     * TODO setja lógík í service
     * vefsíða þar sem notandi getur stofnað nýjan aðgang
     * @param username
     * @param email
     * @param pw1
     * @param pw2
     * @return býr til nýjan aðgang
     */
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
/*
    /**
     * TODO setja lógík í service
     * Vefsíða sem byður notanda að logga sig inn og tjékkar hvort notandi sé til
     * @param uname
     * @param psw
     * @param model
     * @return annaðhvort forsíðu eða notendasíðu eftir því hvort aðgangurinn er til
     */
    /*@RequestMapping(value="/login", method = RequestMethod.POST)
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
    }*/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String synaNotanda(@RequestParam(value = "uname") String nafn, @RequestParam(value = "psw") String lykilorð, Model model ) {
        if (tjaldService.isPwCorr(nafn, lykilorð)) {
            return "campsites/notendasida";
        } else {
            return "campsites/forsida";
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping(value="newTravelPlan")
    public String newTravelPlan(){
        return "campsites/newTravelPlan";
    }

    /**
     * TODO setja lógík í service
     * @param model
     * @return
     */
    @RequestMapping(value = "/addTravel", method = RequestMethod.POST)
    public String addTravel(Model model){
        tpList = (ArrayList<TravelPlan>) travelPlanRep.getAll();
        model.addAttribute("travelplans", tpList);
        return "campsites/addTravel";
    }

    /**
     * TODO setja lógík í service
     * vefsíða sem gerir notenda kleift að búa til nýtt travelplan
     * @param username
     * @param planName
     * @param model
     * @return fer aftur á notendasíðu
     */
    @RequestMapping(value = "/newTravel", method = RequestMethod.POST)
    public String newTravel(@RequestParam(value="username")
                                    String username, @RequestParam(value="planName") String planName, Model model)
    {
        tpList = (ArrayList<TravelPlan>) travelPlanRep.getAll();
        TravelPlan travelplan = new TravelPlan(planName , null, null, 0, 0, 0, username);
        tpList.add(travelplan);
        model.addAttribute("travelplans", tpList);

        return "campsites/notendasida";
    }

    /**
     * TODO setja lógík í service
     * TODO laga svo virki
     * Vefsíða þar sem notandi getur bætt travelitem við travel planið sitt
     * @param campname
     * @param date
     * @param nights
     * @param model
     * @return
     */
    @RequestMapping(value = "/addTravelitem", method = RequestMethod.POST)
    public String newTravel(@RequestParam(value="campS")
                                    String campname, @RequestParam(value="date") Date date,
                            @RequestParam(value="nights") int nights, Model model)
    {
        TravelPlanItem travelplanItem = new TravelPlanItem( date, null, 1000, nights);

        tpiList.add(travelplanItem);
        model.addAttribute("travelplanItems", tpiList);
        return "campsites/addTravel";
    }

    /** Eftirliggjandi Notkunartilvik
     * TODO adminsérsíða þar sem hægt er að bæta/"eyða"/breyta tjaldsvæðum
     * TODO vefsíða birtir upplýsingar um tjaldsvæði
     * TODO vefsíða sem gerir notenda kleift að leita að tjaldsvæði eftir landshluta
     * TODO að traveller geti gefið ummæli
     * TODO traveller geti skoðað ummæli
     * TODO-Sandra admin tjekkari í login, if true birta sér síðu
     *
     */

}
