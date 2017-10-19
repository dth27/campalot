package is.hi.controller;

import is.hi.model.*;
import is.hi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import static com.sun.deploy.config.JREInfo.getAll;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Tekur við skipunum frá vefviðmóti til að notandi geti loggað sig inn
 * búið til nýtt travel plan og bætt í travel planið
 */
@Controller
public class showCampController {
    /**
     * Connections to our services
     */
    @Autowired
    campSiteService CampsiteService;
    @Autowired
    UserService userService;
    @Autowired
    TravelPlanService travelplanService;
    @Autowired
    AlternativeService alternativeService;

    /**
     * Global lists for some models
     */
    ArrayList<TravelPlanItem> tpiList;
    ArrayList<TravelPlan> tpList;
    ArrayList<Camp> cList;
    ArrayList<Campinfo> cList2;
    String user;

    ArrayList<userAccess> mylist;
//    userAccess userobj;

    ArrayList<Review> rList;


    // ===========================
    // FRONTPAGE HANDLING
    // ===========================
    /**
     * @return frontpage
     */
    //TODO breyta yfir i "frontpage" (hafa allt a ensku)
    @RequestMapping("/forsida")
    public String forsida(){
        return "/frontpage";
    }


    // ===========================
    // ACCOUNT HANDLING
    // ===========================
    /**
     *
     * @return vefsíðu sem gerir notenda kleift að stofa nýjan aðgang
     */
    @RequestMapping("/newAccountSite")
    public String newAccountSite(){
        return "newAccountSite";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/accountInfo")
    public String accountInfo(){
        return "accountInfo";
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
    {   boolean doesExist = userService.doesUserExist(username, email);
        boolean PWidentical = userService.arePWidentical(pw1, pw2);
        if (doesExist)
            return "newAccountSite";
        if (PWidentical){
            userService.newLoginUser(username, email, pw1);
            return "/accountInfo";

        }
        return "newAccount";
    }


    // ===========================
    // LOGIN HANDLING
    // ===========================
    /**
     *
     * Vefsíða sem byður notanda að logga sig inn og tjékkar hvort notandi sé til
     * @param name
     * @param psw
     * @param model
     * @return annaðhvort forsíðu eða notendasíðu eftir því hvort aðgangurinn er til
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String synaNotanda(@RequestParam(value = "uname") String name, @RequestParam(value = "psw") String psw, Model model ) {
        if (userService.isPwCorr(name, psw)) {
            user = name;
            ArrayList<Camp> cList;
            user = name;
            cList = CampsiteService.getCampsites();
            model.addAttribute("camps", cList);
            ArrayList<TravelPlan> tpList;
            tpList = travelplanService.getTravelplans();
            model.addAttribute("travelplans", tpList);
            if(userService.hasAdminAuthority(name, psw)){
                return "adminLoginSite";
            }
            return "notendasida";
        } else {
            return "forsida";
        }
    }


    // ===========================
    // TRAVELPLAN HANDLING
    // ===========================
    /**
     *
     * @return
     */
    @RequestMapping(value="newTravelPlan", method = RequestMethod.GET)
    public String newTravelPlan(Model model){
        System.out.println(user);
        mylist = userService.getUser(user);
        if (mylist.isEmpty()){}
        else
        model.addAttribute("users", mylist.get(0));

        return "newTravelPlan";
    }

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = "/addTravel", method = RequestMethod.POST)
    public String addTravel(Model model){
        try{
            tpList = travelplanService.getTravelplans();

        }catch (Exception e){
            System.out.println(e + " getTravelplans in /addTravel");
        }


        model.addAttribute("travelplans", tpList);
        return "notendasida";
    }

    /**
     *
     * vefsíða sem gerir notenda kleift að búa til nýtt travelplan
     * @param planName
     * @param model
     * @return fer aftur á notendasíðu
     */
    @RequestMapping(value = "/newTravel", method = RequestMethod.POST)
    public String newTravel(@RequestParam(value="planName") String planName, Model model)
    {   try {
        ArrayList<Camp> cList;
        cList = CampsiteService.getCampsites();
        model.addAttribute("camps", cList);
        travelplanService.createTravelplan(planName, user);
        tpList = travelplanService.getTravelplans();


        model.addAttribute("travelplans", tpList);
    } catch (Exception e){
        System.out.println("newTravel error");
    }

        return "notendasida";
    }

    /**
     *
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
    public String addTravelItem(@RequestParam(value="date") String date,
                            @RequestParam(value="nights") int nights,
                            @RequestParam(value="travel") String travel, Model model)
    {
        //TODO vantar planname til að tengja við
        Date realDate;
        realDate = alternativeService.dateMaker(date);
        TravelPlanItem travelplanItem = new TravelPlanItem(5, realDate, realDate, 1000, nights);
        travelplanService.addItemtoPlan(travel, travelplanItem);
        tpiList = new ArrayList<TravelPlanItem>();
        try{

            tpiList.add(travelplanItem);

        }catch (Exception e){
            System.out.println("addTravelItem error" +" "+e);
        }
        ArrayList<Camp> cList;
        cList = CampsiteService.getCampsites();
        model.addAttribute("camps", cList);

        //model.addAttribute("travelplanItems", tpiList);
        tpList = travelplanService.getTravelplans();

        model.addAttribute("travelplans", tpList);

        return "notendasida";
    }


    // ===========================
    // NAVIGATION MENU HANDLING
    // ===========================
    /**
     *
     * @return
     */
    @RequestMapping(value="/UserReviews", method = RequestMethod.GET)
    public String checkNavi(){

        return "UserReviews";
    }


    // ===========================
    // CAMP INFO HANDLING
    // ===========================
    /**
     * @param model
     * @return website with list of all campsites
     */
    @RequestMapping(value = "/listofcamps", method = RequestMethod.GET)
    public String listCamps(Model model) {
        ArrayList<Camp> cList;
        ArrayList<Campinfo> cList2;
        cList = CampsiteService.getCampsites();
        cList2 = CampsiteService.getCampinfo();
        model.addAttribute("camps", cList2);
        return "allCampsites";
    }
    /**
     * @return Vefsíða með upplýsingum um tjaldsvæði
     */
    @RequestMapping("/campInfo")
    public String campInfo() {
        return "campInfo";
    }

    /**
     * Sækir öll tjalddsvæði og flokkar eftir landshluta.
     *
     * @param model
     * @param area
     * @return skilar síðu þar sem hægt er að sjá tjaldsvæðin.
     */
    @RequestMapping(value = "/showCamps", method = RequestMethod.POST)
    public String showCamps(Model model,
                            @RequestParam(value = "area") String area) {

        cList2 = CampsiteService.getCampinfo();
        ArrayList<Campinfo> cList3 = new ArrayList<Campinfo>();

        for (Campinfo c : cList2) {
            if (c.getRegion().equals(area)) {
                cList3.add(c);

            }
            model.addAttribute("camps", cList3);
        }
        if (area.equals("All"))
            model.addAttribute("camps", cList2);


        return "allCampsites";
    }


    /**
     * Sækir upplýsingar um tjaldsvæði
     *
     * @param campName
     * @param model
     * @return skilar síðu þar sem hægt er að skoða upplýsingar um tjaldsvæði
     */
    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public String getInfo(@RequestParam(value = "campName") String campName, Model model) {
        //TODO thurfum ekki oll campsites

        rList = userService.getReviews(campName);
        Campinfo campinfo = CampsiteService.getOneCampinfo(campName);
        // ArrayList<AverageRating> aList = new ArrayList<AverageRating>();
        //double rate = userService.getRating(campName);
        model.addAttribute("reviews", rList);
        //model.addAttribute("rate", rate);
        model.addAttribute("campinfo", campinfo);

        return "campInfo";
    }


    // ===========================
    // REVIEW AND RATING HANDLING
    // ===========================
    /**
     * @return skilar síðu þar sem hægt er að skrifa ummæli.
     */
    @RequestMapping(value = "giveReview")
    public String giveReview() {
        return "giveReview";
    }

    /**
     * finnur út hvaða tjaldsvæði notandi vill gefa ummæli.
     *
     * @param campName
     * @param model
     * @return skilar síðu þar sem hægt er að skrifa ummæli
     */
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public String review(@RequestParam(value = "campName") String campName, Model model) {
        System.out.println(campName);
        cList2 = CampsiteService.getCampinfo();
        try{
            for (Campinfo c : cList2) {
            if (c.getCampname().equals(campName))
                model.addAttribute("camp", c);
        }}catch(Exception e){
            System.out.println("inní /review: "+e);
        }
        return "giveReview";
    }

    /**
     * Vefsíða sem sýnir upplýsingar um tjaldsvæði
     *
     * @param myReview
     * @param campName
     * @param model
     * @return skilar síðu með upplýsingu
     */
    @RequestMapping(value = "/postReview", method = RequestMethod.POST)
    public String postReview(@RequestParam(value = "myReview") String myReview,
                             @RequestParam(value = "campName") String campName, Model model) {


        Review review = new Review(myReview, user, campName);
        userService.addReview(review);
        Campinfo campinfo = CampsiteService.getOneCampinfo(campName);
        model.addAttribute("campinfo", campinfo);
        ArrayList<Review> rList = userService.getReviews(campName);
        model.addAttribute("reviews", rList);
        return "campInfo";

    }

    /**
     * //TODO tengja og laga
     * @param rating
     * @param campName
     * @param model
     * @return
     */
    @RequestMapping(value = "giveRating", method = RequestMethod.POST)
    public String giveRating(@RequestParam(value = "rating") int rating,
                             @RequestParam(value = "campName2") String campName, Model model) {
        /*
        userService.setRating(rating, campName);
        //ArrayList<Review> rev = userService.getReviews();
        double rate;
        for (Camp c : cList) {
            if (c.getCampname().equals(campName)) {
                aList = c.getRatings();
                aList.add(rating1);
                c.setRatings(aList);
                int i = 0;
                for (AverageRating a : aList) {
                    i = i + a.getVoted();
                }

                rate = i / aList.size();
                model.addAttribute("camp", c);
                model.addAttribute("rate", rate);
                model.addAttribute("reviews", c.getReviews());
            }
        }*/
        return "campInfo";
    }

}
