package in.hp.boot.userinfoservice.repositories;

import in.hp.boot.userinfoservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    List<User> findByFnameAndLname(String fname, String lname);

    @Query("SELECT u FROM User u WHERE u.fname = ?1 AND u.lname = ?2")
    User findByUserFnameAndLname(String fname, String lname);
}
