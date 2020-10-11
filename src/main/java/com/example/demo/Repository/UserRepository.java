package com.example.demo.Repository;

import com.example.demo.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    Optional<User> findOneByLogin(String login);

    @Query(value = "delete from fix_user where id=:id")
    void deleteId(@Param("id") Long id);
}
