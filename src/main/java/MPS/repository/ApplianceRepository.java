package MPS.repository;

import MPS.models.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by manish.rastogi on 20/1/16.
 */
@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

    @Query("SELECT a FROM Appliance a where a.enterprise = :ent_id")
    List<Appliance> findApplianceByEnt_id(@Param("ent_id") long ent_id);
}
