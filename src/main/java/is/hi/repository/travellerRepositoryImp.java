package is.hi.repository;


import is.hi.model.Traveller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Collection of travellers
 */

@Repository
public class travellerRepositoryImp implements travellerRepository {
    private final List<Traveller> travellers;
   // private Traveller mockTraveller;
    public travellerRepositoryImp(){
        this.travellers = new ArrayList<Traveller>();
        Traveller traveller = new Traveller("ofm1", "ofm1@hi.is", "password");
        travellers.add(traveller);
    }

    @Override
    public List<Traveller> getAll(){
        return travellers;
    }
    @Override
    public void add (Traveller traveller){
        travellers.add(traveller);
    }
    //TODO búa til mock obj og lista fyrir Review
    @Override
    public String getReviews(String username){
        for (int i=0; i<travellers.size(); i++){
            if (travellers.get(i).equals(username)){
                //TODO travellers ætti frekar vera listi af reviews
            }
        }
        return username;
    }
}
