package com.example.testApp.repository;

import com.example.testApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u left join fetch u.account where u.username=:username")
    User findByUsername(String username);
    @Query("select u from User u where :phone in elements(u.phones) ")
    User findByPhone(@Param("phone") String phone);
    @Query("select u from User u where :email in elements(u.emails) ")
    User findByEmail(@Param("email") String email);
}
