package is.hi.controller;

/**
 *
 * @author Ólöf Fríða (ofm1@hi.is)
 * @author Kristín María Tómasdóttir
 * @author Diljá Þorkelsdóttir
 * @author Sandra Mar Huldudóttir
 * Kóði fenginn frá Ebbu
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Byrjunarcontroller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun
 */

@Controller
@RequestMapping("/demo") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /demo fyrir allar skipanir 
public class DemoController {

    /**
     * Spyr hvað notandinn heitir
     * @return Heimasíða sem spyr hvað notandinn heitir
     */
    @RequestMapping("/spyrjaNotanda")
    public String spyrjaNotandi(){
        return "demo/hvadaNotandi";
    }

    /**
     * Tekur við nafni frá notanda og birtir goodd morning nafn
     * @param nafn Nafn á notanda
     * @param model Módel með attributum
     * @return heimasíðan synaNotandi
     */
    @RequestMapping(value="/hver", method=RequestMethod.POST)
    public String hver(@RequestParam(value="nafn", required=false)
                                   String nafn, ModelMap model) {
        model.addAttribute("nafn" ,nafn);
        return "demo/synaNotandi";
    }

}
