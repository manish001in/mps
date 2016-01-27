package MPS.repository;

import MPS.models.Enterprises;
import MPS.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by manish.rastogi on 20/1/16.
 */
@Repository
public interface EnterprisesRepository extends JpaRepository<Enterprises, Long> {

    Enterprises findById(Long id);

    @Query("SELECT e.id,e.entpName,e.contactPerson,e.createdDate FROM Enterprises e")
    List<Enterprises> findAllEnterprises();

    @Query("SELECT e FROM Enterprises e where e.id = :id")
    Enterprises findEnterprise(@Param("id") Long id);
}
