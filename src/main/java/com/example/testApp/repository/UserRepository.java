package com.example.testApp.repository;

import com.example.testApp.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u left join fetch u.account where u.username=:username")
    User findByUsername(String username);
    @Query("select u from User u where :phone in elements(u.phones) ")
    User findByPhone(@Param("phone") String phone);
    @Query("select u from User u where :email in elements(u.emails) ")
    User findByEmail(@Param("email") String email);

    Page<User> findByBirthDateAfter(LocalDate birthdate, Pageable pageable);

    Page<User> findByFirstNameLikeOrLastNameLike(String firstName, String lastName, Pageable pageable);
}
