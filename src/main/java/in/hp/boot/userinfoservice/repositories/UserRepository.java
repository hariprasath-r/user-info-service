package in.hp.boot.userinfoservice.repositories;

import in.hp.boot.userinfoservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Integer, User> {

    @Query("SELECT u FROM USER u WHERE u.fname = ?1 AND u.lname = ?2")
    User findByName(String fname, String lname);
}
