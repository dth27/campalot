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
    campSiteService CampsiteService;
    @Autowired
    UserService userService;
    @Autowired
    TravelPlanService travelplanService;
    @Autowired
    AlternativeService alternativeService;

   // @Autowired
    //campsiteRepository campRep;
   // @Autowired
   // travelPlanRepository travelPlanRep;
   // @Autowired
   // travellerRepository travellerRep;
   // @Autowired
   // travelPlanItemRepository travelPlanItemRep;

    ArrayList<TravelPlanItem> tpiList;
    ArrayList<TravelPlan> tpList;
    //ArrayList<Traveller> tList;

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
        cList = CampsiteService.getCampsites();
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
     *
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
    {   boolean doesExist = userService.doesTravellerExist(username, email);
        boolean PWidentical = userService.arePWidentical(pw1, pw2);
        if (doesExist)
                return "campsites/newAccountSite";
        if (PWidentical){
            userService.newTraveller(username, email, pw1);
            return "campsites/accountInfo";
        }
        return "campsites/newAccount";
    }
/*
    /**
     *
     * Vefsíða sem byður notanda að logga sig inn og tjékkar hvort notandi sé til
     * @param uname
     * @param psw
     * @param model
     * @return annaðhvort forsíðu eða notendasíðu eftir því hvort aðgangurinn er til
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String synaNotanda(@RequestParam(value = "uname") String nafn, @RequestParam(value = "psw") String lykilorð, Model model ) {
        if (userService.isPwCorr(nafn, lykilorð)) {
            //TODO tengja við service til að birta Camp og TravelPlan
            ArrayList<Camp> cList;
            cList = CampsiteService.getCampsites();
            model.addAttribute("camps", cList);

            ArrayList<TravelPlan> tpList;
            tpList = travelplanService.getTravelplans();
            model.addAttribute("travelplans", tpList);

            return "campsites/notendasida";
        } else {
            return "campsites/forsida";
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping(value="newTravelPlan", method = RequestMethod.GET)
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

        tpList = travelplanService.getTravelplans();

        model.addAttribute("travelplans", tpList);
        return "campsites/notendasida";
    }

    /**
     *
     * vefsíða sem gerir notenda kleift að búa til nýtt travelplan
     * @param username
     * @param planName
     * @param model
     * @return fer aftur á notendasíðu
     */
    @RequestMapping(value = "/newTravel", method = RequestMethod.POST)
    public String newTravel(@RequestParam(value="username")
                                    String username, @RequestParam(value="planName") String planName, Model model)
    {   try {
        travelplanService.createTravelplan(planName, username);
        tpList = travelplanService.getTravelplans();
        model.addAttribute("travelplans", tpList);
        } catch (Exception e){
        System.out.println("newTravel error");
    }

        return "campsites/notendasida";
    }

    /**
     * TODO setja lógík í service
     * TODO laga svo virki
     * Vefsíða þar sem notandi getur bætt travelitem við travel planið sitt
     * //@param campname
     *
     * //@param date
     * @param nights
     * @param model
     * @return
     */
    @RequestMapping(value = "/addTravelitem", method = RequestMethod.POST)
    public String newTravel(@RequestParam(value="date") String date,
                            @RequestParam(value="nights") int nights,
                            @RequestParam(value="travel") String travel, Model model
                            )
    {
        //TODO vantar planname til að tengja við
        Date realDate = new java.util.Date();
        realDate = alternativeService.dateMaker(date);
        TravelPlanItem travelplanItem = new TravelPlanItem( realDate, null, 1000, nights);
        travelplanService.addItemtoPlan(travel, travelplanItem);
        try{

        tpiList.add(travelplanItem);

        }catch (Exception e){
            System.out.println("addTravelItem error");
        }
        ArrayList<Camp> cList;
        cList = CampsiteService.getCampsites();
        model.addAttribute("camps", cList);

        //model.addAttribute("travelplanItems", tpiList);
        tpList = travelplanService.getTravelplans();

        model.addAttribute("travelplans", tpList);

        return "campsites/notendasida";
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
    @RequestMapping(value="/UserReviews", method = RequestMethod.GET)
    public String checkNavi(){
        return "campsites/UserReviews";
    }

}
