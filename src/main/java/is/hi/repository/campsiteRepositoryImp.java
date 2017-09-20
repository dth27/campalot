package is.hi.repository;

import is.hi.model.Camp;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class campsiteRepositoryImp implements campsiteRepository {
    private final List<Camp> camps;

   // private Camp mockCamp;
    public campsiteRepositoryImp(){
        this.camps = new ArrayList<Camp>();
        Camp camp = new Camp("Tjaldsvæði",1000,"no service","05:00-22:00","no shops", "no entertainment","South",8,2);
        Camp camp1 = new Camp("Tjaldsvæði1",1000,"no service","05:00-22:00","no shops", "no entertainment","South",8,2);
        camps.add(camp1);
        Camp camp2 = new Camp("Tjaldsvæði2",2000,"so much service","05:00-22:00","very good shops", "PARTY","North",10,3);
        camps.add(camp2);
        camps.add(camp);
    }

    @Override
    public List<Camp> getAll(){
        return camps;
    }
    @Override
    public void add (Camp camp){
        camps.add(camp);
    }
}
