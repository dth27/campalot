package is.hi.repository;

import is.hi.model.Camp;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class campsiteRepositoryImp implements campsiteRepository {
    private final List<Camp> camps;
    public campsiteRepositoryImp(){
        this.camps = new ArrayList<Camp>();
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
