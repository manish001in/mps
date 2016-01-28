package MPS.repository;


import MPS.models.Appliance;
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
public interface UserRepository extends JpaRepository <Users, Long> {

    Users findById(Long id);

    @Query("SELECT u FROM Users u where u.id = :id")
    Users findUser(@Param("id") Long id);

    @Query("SELECT u FROM Users u where u.enterprise = :ent_id")
    List<Users> findUsersByEnt_id(@Param("ent_id") Enterprises ent_id);

}
