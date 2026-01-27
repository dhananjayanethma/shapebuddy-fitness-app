package com.vortech.shapebuddybackend.Repository;

import com.vortech.shapebuddybackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);

    User findByUsernameAndPassword(String username,String password);
}
