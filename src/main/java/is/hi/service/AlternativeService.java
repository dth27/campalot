package is.hi.service;

import is.hi.model.TravelPlanItem;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 *
 */

public interface AlternativeService {
    Date dateMaker(String date);
    ArrayList dateChanger(ArrayList<TravelPlanItem> list);
}
