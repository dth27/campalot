package is.hi.repository;


import is.hi.model.TravelPlan;
        import org.springframework.stereotype.Repository;

        import java.util.ArrayList;
        import java.util.List;

@Repository
public class travelPlanRepositoryImp implements travelPlanRepository {
    private final List<TravelPlan> travelplans;
    // private TravelPlan mockTravelPlan;
    public travelPlanRepositoryImp(){
        this.travelplans = new ArrayList<TravelPlan>();
        TravelPlan travelplan = new TravelPlan("Ferðalag 1" , null, null, 0, 0, 0, "ofm1");
        travelplans.add(travelplan);

    }

    @Override
    public List<TravelPlan> getAll(){
        return travelplans;
    }
    @Override
    public void add (TravelPlan travelplan){
        travelplans.add(travelplan);
    }
}
