package is.hi.controller;

import is.hi.model.*;
import is.hi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

//import static com.sun.deploy.config.JREInfo.getAll;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Tekur við skipunum frá vefviðmóti til að notandi geti loggað sig inn
 * skoðað lista yfir tjaldsvæði og nánari upplýsingar um hvert og eitt þeirra
 * búið til nýtt travel plan og bætt travelplanitems í travel planið
 * gefið tjaldsvæði einkunn og umsögn
 * bætt við nýju tjaldsvæði, breytt því eða eytt (einungis admin)
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

    /**-------------------------------
     * Global lists for some models
     */-------------------------------

    /**
     * An Arraylist of Travel Plan Items
     */
    ArrayList<TravelPlanItem> tpiList;

    /**
     * An Arraylist of Travel Plans
     */
    ArrayList<TravelPlan> tpList;

    /**
     * An Arraylist of Campinfo
     */
    ArrayList<Campinfo> cList2;

    /**
     * An Arraylist of users
     */
    ArrayList<userAccess> mylist;

    /**
     * An Arraylist of a single camp review
     */
    ArrayList<Review> rList;

    /**
     * An Arraylist of camp's average ratings
     */
    ArrayList<AverageRating> ratList;

    /**
     * An Arraylist of all camp's reviews
     */
    ArrayList<Review> allRevList;


    //ArrayList<Camp> cList;
    String user;
    String campValue;
    boolean isLoggedIn = false;


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
     * Site to create a new user
     * @param model     model Object
     * @return          page that the user can sign up for a new account
     */
    @RequestMapping("/newAccountSite")
    public String newAccountSite(Map<String, Object> model) {
        model.put("newUserForm", new userAccess());
        return "newAccountSite";
    }

    /**
     * Site to handle user's information
     * @param model     model Object
     * @return          page that has the information on the user's account
     */
    @RequestMapping("/accountInfo")
    public String accountInfo(Model model) {
        userAccess accountinfo = userService.getUserInfo(user);
        model.addAttribute("user", accountinfo);
        return "accountInfo";
    }

    /**
     * Site to create a new login account
     * @param villur    villur (String)
     * @param model    Model Object
     * @return          page that informs that an account has been created
     */
    @RequestMapping(value = "/newAccount", method = RequestMethod.POST)
    public String newAccount(@Valid @ModelAttribute("newUserForm")
                                     userAccess newUser, BindingResult villur,
                             Model model, @RequestParam(value = "pw") String pw) {
        if (villur.hasErrors()) {
            return "newAccountSite";
        } else {
            if (userService.arePWidentical(pw, newUser.getPassword())) {
                userService.newLoginUser(newUser);
                model.addAttribute("user", newUser);

                return "accountInfo";
            } else {
                model.addAttribute("passwordError", "The passwords do not match");
                return "newAccountSite";
            }
        }

    }

    // ===========================
    // LOGIN HANDLING
    // ===========================
    /**
     *
     * Vefsíða sem biður notanda að logga sig inn og tjékkar hvort notandi sé til
     * @param name      name of the user (String)
     * @param psw       password of the user (String)
     * @param model     model Object
     * @return annaðhvort forsíðu eða notendasíðu eftir því hvort aðgangurinn er til
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String synaNotanda(@RequestParam(value = "uname") String name, @RequestParam(value = "psw") String psw, Model model ) {
        if (userService.isPwCorr(name, psw)) {
            user = name;
            cList2 = CampsiteService.getCampinfo();
            model.addAttribute("camps", cList2);
            ArrayList<TravelPlan> tpList;
            tpList = travelplanService.getUserTravelplan(user);
            model.addAttribute("travelplans", tpList);
            isLoggedIn = true;
            if(userService.hasAdminAuthority(name, psw)){
                return "adminLoginSite";
            }
            return "notendasida";
        } else {
            model.addAttribute("error", "Username or password is incorrect");
            return "frontpage";
        }
    }


    // ===========================
    // TRAVELPLAN HANDLING
    // ===========================

    /**
     * Site to create a new travel plan
     * @param model     model object
     * @return          page showing the new travel plan
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
     * Site to add travel plan
     * @param model     model Object
     * @return          user page of the logged in user (notendasíða)
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
     * vefsíða sem gerir notenda kleift að búa til nýtt travelplan
     * @param planName      name of the new travel plan
     * @param model         model object
     * @return fer aftur á notendasíðu
     */
    @RequestMapping(value = "/newTravel", method = RequestMethod.POST)
    public String newTravel(@RequestParam(value="planName") String planName, Model model)
    {   try {

        cList2 = CampsiteService.getCampsites();
        model.addAttribute("camps", cList2);
        travelplanService.createTravelplan(planName, user);
        tpList = travelplanService.getUserTravelplan(user);


        model.addAttribute("travelplans", tpList);
    } catch (Exception e){
        System.out.println("newTravel error");
    }

        return "notendasida";
    }

    /**
     * Site to add a camp item to a single travel plan
     * @param campname     name of the camp to be added
     * @param model        model Object
     * @return             page to handle adding the travel plan item to travel plan
     */
    @RequestMapping(value="/addToPlan", method = RequestMethod.POST)
    public String addToPlan(@RequestParam(value="Campname") String campname, Model model){
        Campinfo camp = CampsiteService.getOneCampinfo(campname);
        model.addAttribute("camp", camp);
        tpList = travelplanService.getTravelplans();
        ArrayList Greta;
        Greta = travelplanService.getTravelplans();
        campValue = campname;

        model.addAttribute("travelplans", Greta);
        return "newTravelPlanItem";

    }
    /**
     * TODO laga svo virki
     * Page to handle adding the travel plan item to travel plan
     * //@param campname    name of the camp to be added
     * //@param date        date when travelplanitem/camp is to be used
     * @param model         model Object
     * @return              page of user (notendasíða)
     */
    @RequestMapping(value = "/addTravelitem", method = RequestMethod.POST)
    public String addTravelItem(
                            @RequestParam(value="datearrive") String datearr,
                            @RequestParam(value="datedepart") String datedep,
                            @RequestParam(value="travels") String travel,
                             Model model)
    {
        //TODO vantar planname til að tengja við
        Date realDatearr, realDatedep;

        realDatearr = alternativeService.dateMaker(datearr);
        realDatedep = alternativeService.dateMaker(datedep);
        TravelPlanItem travelplanItem = new TravelPlanItem(realDatearr, realDatedep, 1000, campValue, user, travel);
        travelplanService.addItemtoPlan(travel, travelplanItem);
        tpiList = new ArrayList<TravelPlanItem>();
        System.out.println(travel);
        try{

            tpiList.add(travelplanItem);

        }catch (Exception e){
            System.out.println("addTravelItem error" +" "+e);
        }

        cList2 = CampsiteService.getCampsites();
        model.addAttribute("camps", cList2);

        //model.addAttribute("travelplanItems", tpiList);
        tpList = travelplanService.getTravelplans();
        System.out.println(tpList.get(1).getTravelplanname());
        model.addAttribute("travel", tpList);

        return "notendasida";
    }


    // ===========================
    // NAVIGATION MENU HANDLING
    // ===========================

    /**
     * Site that handles view of user's reviews
     * @param model     model object
     * @return          the page that shows all the user's reviews
     */
    @RequestMapping(value="/UserReviews", method = RequestMethod.GET)
    public String seeUserReviews(Model model){
        allRevList = userService.getAllReviews();
        model.addAttribute("reviews", allRevList);
        return "UserReviews";
    }

    /**
     * Site that handles view of the user's travel plans
     * @param model     model object
     * @return          page that shows all the user's travel plans
     */
    @RequestMapping(value = "/myTravelplans", method = RequestMethod.GET)
    public String seeTravelPlans(Model model) {
        ArrayList<TravelPlan> userList = travelplanService.getUserTravelplan(user);
        model.addAttribute("travelplans", userList);
        return "myTravelPlans";
    }


    // ===========================
    // CAMP INFO HANDLING
    // ===========================

    /**
     * Site that handles a list of all the camps
     * @param model     model object
     * @return          page with a list of all campsites
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
     * Site for the camp info
     * @return      page that shows the camp info
     */
    @RequestMapping("/campInfo")
    public String campInfo() {
        return "campInfo";
    }

    /**
     * Sækir öll tjalddsvæði og flokkar eftir landshluta
     *
     * @param model     model object
     * @param area      landshluti þar sem tjaldsvæðið er staðsett (String)
     * @return          skilar síðu þar sem hægt er að sjá tjaldsvæðin
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
     * @param campName      name of the camp (String)
     * @param model         model object
     * @return skilar síðu þar sem hægt er að skoða upplýsingar um tjaldsvæði
     */
    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public String getInfo(@RequestParam(value = "campName") String campName, Model model) {
        //TODO thurfum ekki oll campsites

        rList = userService.getReviews(campName);
        Campinfo campinfo = CampsiteService.getOneCampinfo(campName);
        model.addAttribute("reviews", rList);
        model.addAttribute("campinfo", campinfo);
        return "campInfo";
    }



    // ===========================
    // ADMIN LOGIN SITE HANDLING
    // ===========================



    // --------------------------------
    // BÆTA VIÐ NÝJU TJALDSVÆÐI -ADMIN
    // --------------------------------

    /**
     * Tekur inn nafn á nýju tjaldsvæði (camp) frá admin
     * @param myNewCamp     Name of the new camp (String)
     * @param model         Model Object
     * @return  skilar síðunni adminAddNewCamp (sem tekur inn allar upplýsingar fyrir nýja tjaldsvæðið og býr það til)
     */
    @RequestMapping(value = "/addNewCampRequest", method = RequestMethod.POST)
    public String postReview(@RequestParam(value = "newCampName") String myNewCamp, Model model) {

        System.out.println("The new campname is: " + myNewCamp);
        boolean doesExist = CampsiteService.doesCampExist(myNewCamp);
        System.out.println("Nýja nafnið yfir campname sem er tekið í reqParam í addnewCamp er: " + myNewCamp);
        System.out.println("Campsite does exist: " + doesExist);

        if (doesExist) {
            System.out.println("The campname does already exists");
            model.addAttribute("AdminMessage", "This campname does already exist");
            return "adminLoginSite";
        } else {
            model.addAttribute("campname", myNewCamp);
            return "adminAddNewCamp";
        }
    }

    /**
     * site where admin can add a new camp into the database
     * @param campname      name of the camp (String)
     * @param campaddress   address of the camp (String)
     * @param campzip       zip code of the camp (String)
     * @param campemail     email of the camp (String)
     * @param campphone     phone number of the camp (String)
     * @param campwebsite   website of the camp (String)
     * @param campseason    opening season of the camp (String)
     * @param maincategory  main category of the camp (String)
     *                      (e.g. gisting/veitingar/upplýsingar...)
     * @param category      category of the camp (String)
     *                      (e.g. tjaldsvæði/bændagisting/hostel/farfuglaheimili...)
     * @param region        region of the camp (String)
     *                      (e.g. Suðurland/Norðurland/Austurland/Vesturland/Vestfirðir/Höfuðborgarsvæðið...)
     * @param description   description of the camp (String)
     * @param xval          coordinates for latitude of the camp (int)
     * @param yval          ooordinates for longitude of the camp (int)
     * @param model         model object
     * @return              the adminLoginSite with the updated camp list
     */
    @RequestMapping(value = "/addNewCamp", method = RequestMethod.POST)
    public String newCamp(@RequestParam(value="campname") String campname,
                          @RequestParam(value="campaddress") String campaddress,
                          @RequestParam(value="campzip") String campzip,
                          @RequestParam(value="campemail") String campemail,
                          @RequestParam(value="campphone") String campphone,
                          @RequestParam(value="campwebsite") String campwebsite,
                          @RequestParam(value="campseason") String campseason,
                          @RequestParam(value="maincategory") String maincategory,
                          @RequestParam(value="category") String category,
                          @RequestParam(value="region") String region,
                          @RequestParam(value="description") String description,
                          @RequestParam(value="xval") int xval,
                          @RequestParam(value="yval") int yval, Model model) {

        Campinfo newcampinfo = new Campinfo(campname, campaddress, campzip, campemail, campphone, campwebsite,
                campseason, maincategory, category, region, description, xval, yval, 0.0);

            CampsiteService.addNewCamp(newcampinfo);
            //model.addAttribute("newcampinfo", newcampinfo);
            //TODO: Bæta við í skilaboðunum nafninu, þ.e. (newcampinfo.campname)
            model.addAttribute("AdminMessage", "The new camp has been added to the list");
            //TODO: Búa til uppfærðan camplista til að sýna í adminLoginSite
            //cList2 = CampsiteService.getCampinfo();
            //model.addAttribute("camp", cList2);
            return "adminLoginSite";
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
     * @param campName      name of the camp (String)
     * @param model         model object
     * @return skilar síðu þar sem hægt er að skrifa ummæli
     */
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public String review(@RequestParam(value = "campName") String campName, Model model) {
        if(!isLoggedIn) {
            return "campInfoError";
        }
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
     * Site to handle the posting of the review
     * @param myReview      the user's review (String)
     * @param campName      the camp name for the review (String)
     * @param model         model object
     * @return              page that shows all the information of the camp in question
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
     * Site for handling rating a camp
     * @param myRating      the user's rating for the camp (String)
     * @param campName2     the name of the camp (String)
     * @param model         model Object
     * @return
     */
    @RequestMapping(value = "giveRating", method = RequestMethod.POST)
    public String giveRating(@RequestParam(value = "rating") int myRating,
                             @RequestParam(value = "campName2") String campName2, Model model) {
        if(!isLoggedIn) {
            return "campInfoError";
        }
        AverageRating rat = new AverageRating(myRating, user, campName2);
        userService.setRating(rat);
        double avrat = userService.getRating(campName2);
        userService.setAvRating(avrat, campName2);
        Campinfo campinfo = CampsiteService.getOneCampinfo(campName2);
        model.addAttribute("campinfo", campinfo);
        model.addAttribute("reviews", rList);
        return "campInfo";
    }

    /**
     * Site to see the ratings for a single camp
     * @param campName2         name of the camp (String)
     * @param model             model object
     * @return                  page that shows the rating for the camp
     */
    @RequestMapping(value = "/allratings", method = RequestMethod.POST)
    public String seeAllRatings(@RequestParam(value = "allrat") String campName2, Model model){
        Campinfo campinfo = CampsiteService.getOneCampinfo(campName2);
        model.addAttribute("campinfo", campinfo);
        ratList = userService.getRatings(campName2);
        model.addAttribute("ratings", ratList);
        return "seeAllRatings";
    }

    /**
     * Dæmi til að sýna prófanir með kalli á service klasa
     * @return skilar frontpage ef þjónustan "er á lífi" annars allCampsites
     */
    @RequestMapping (value = "/lifir", method=RequestMethod.GET)
    public String lifir() {
        if(CampsiteService.erALifi())
            return "frontpage";
        else
            return "allCampsites";
    }
}
