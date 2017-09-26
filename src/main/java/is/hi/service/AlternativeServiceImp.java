package is.hi.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AlternativeServiceImp implements AlternativeService {

    @Override
    public Date dateMaker(String strdate){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = new java.util.Date();
        try{
            date = sdf.parse(strdate);
            return date;}
        catch(Exception e) {
            System.out.println("whoops");
        }
        finally {
            return date;

        }

    }
}
