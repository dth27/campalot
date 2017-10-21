package is.hi.service;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
}

