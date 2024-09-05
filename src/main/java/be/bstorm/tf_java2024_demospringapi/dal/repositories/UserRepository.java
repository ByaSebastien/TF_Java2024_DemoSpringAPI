package be.bstorm.tf_java2024_demospringapi.dal.repositories;

import be.bstorm.tf_java2024_demospringapi.dl.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.username ilike :username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("select count(u) > 0 from User u where u.username ilike :username")
    boolean existsByUsername(@Param("username") String username);
}
