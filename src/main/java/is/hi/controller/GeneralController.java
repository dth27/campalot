package is.hi.controller;

import is.hi.model.userAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class GeneralController {


    /**
     * Returns frontpage
     * @return frontpage
     */
    @RequestMapping("/")
    public String forsida()
    {
        return "frontpage";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "goToFrontpage")
    public String goToFrontpage(Model model){

        return "/frontpage";
    }

    /**
     * Site to create a new user
     * @param model     model Object
     * @return          page that the user can sign up for a new account
     * @return          page that the user can sign up for a new account
     */
    @RequestMapping("/newAccountSite")
    public String newAccountSite(Map<String, Object> model) {
        //model.put("newUserForm", new userAccess());
       // return "newAccountSite";
        return "/";
    }

    @RequestMapping(value="login", method= RequestMethod.GET)
    public String login(){
        return "/loginpage";
    }



    @RequestMapping(value="userlogin", method= RequestMethod.POST)
    public String userlogin(){
        //TODO check user
        //TODO get travel plans and so on

        return "/userpage";
    }

    @RequestMapping(value="accountinfo", method= RequestMethod.GET)
    public String accountinfo(){
        //TODO get user info
        //TODO check if logged in?

        return "/accountpage";
    }


    @RequestMapping(value="travelplans", method= RequestMethod.GET)
    public String travelplans(){
        //check user
        //get travel plans and so on

        return "/usertravelplans";
    }
    @RequestMapping(value="starttravel", method= RequestMethod.POST)
    public String startTravel(){
        //check if user is active
        //check what travel plan to activate
        //could also be "activate travelplan?


        return "/userpage";
    }

}