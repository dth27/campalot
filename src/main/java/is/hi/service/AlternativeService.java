package is.hi.service;

import is.hi.model.TravelPlanItem;

import java.util.ArrayList;
import java.util.Date;


public interface AlternativeService {

    Date dateMaker(String date);
    ArrayList dateChanger(ArrayList<TravelPlanItem> list);
}
