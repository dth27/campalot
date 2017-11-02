package is.hi.service;

import is.hi.model.TravelPlanItem;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AlternativeServiceImp implements AlternativeService {

    @Override
    public Date dateMaker(String strdate){

        SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String dateAsString = "25/12/2010";
        Date date = new Date();
        try{
            date = sourceFormat.parse(strdate);
            return date;
        }
        catch(Exception e) {
            System.out.println("date went wrong" + " " + date + " " + strdate);
        }
        finally {
            return date;

        }

    }
    @Override
    public ArrayList dateChanger(ArrayList<TravelPlanItem> list){
        //List dates;
        for (TravelPlanItem i : list){
            Date arr = i.getDatearrive();
            long millisInDay = 60 * 60 * 24 * 1000;
            long currentTime = arr.getTime();
            long dateOnly = (currentTime / millisInDay) * millisInDay;
            arr = new Date(dateOnly);
            i.setDatearrive(arr);
        }
        for (TravelPlanItem j : list){
            Date dep = j.getDatearrive();
            long millisInDay = 60 * 60 * 24 * 1000;
            long currentTime = dep.getTime();
            long dateOnly = (currentTime / millisInDay) * millisInDay;
            //dep = new Date(dateOnly);
            j.setDatedepart(dep);
            dep.toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dateWithoutTime = sdf.parse(sdf.format(dep));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
       return list;
    }
}

