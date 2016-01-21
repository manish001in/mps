package MPS.repository;

import MPS.models.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by manish.rastogi on 20/1/16.
 */
@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {
}
