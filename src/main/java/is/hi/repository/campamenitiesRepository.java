package is.hi.repository;

import is.hi.model.CampAmenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface campamenitiesRepository extends JpaRepository<CampAmenities, Long> {

    public List<CampAmenities> findAllByCampname(String campname);

}
