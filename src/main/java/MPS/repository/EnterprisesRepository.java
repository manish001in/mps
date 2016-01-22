package MPS.repository;

import MPS.models.Enterprises;
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




}
