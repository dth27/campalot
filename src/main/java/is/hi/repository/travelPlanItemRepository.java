package is.hi.repository;

import is.hi.model.TravelPlanItem;

import java.util.List;

public interface travelPlanItemRepository {

    List<TravelPlanItem> getAll();
    void add(TravelPlanItem travelplanItem);
}
