package MPS.repository;


import MPS.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by manish.rastogi on 20/1/16.
 */
@Repository
public interface UserRepository extends JpaRepository <Users, Long> {


}
