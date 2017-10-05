package is.hi.repository;

import is.hi.model.Campinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface campinfoRepository extends JpaRepository<Campinfo, Long>{

    /**
     * Get all campinfo
     */
    @Query(value = "SELECT n FROM Campinfo n")
    List<Campinfo> getAll();
}
