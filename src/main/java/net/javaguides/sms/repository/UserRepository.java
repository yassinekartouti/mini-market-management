package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.sms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u from User u Where u.Username = :Username")
    public User getUserByUsername(@Param("Username") String Username);

    @Query("SELECT u from User u Where u.id = :id")
    public User getUserByid(@Param("id") String id);
}
