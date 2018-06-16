package rest.java.restApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.java.restApi.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> getUserByName(@Param("name") String name);

}
