package com.vortech.shapebuddybackend.Service;

import com.vortech.shapebuddybackend.Entity.User;
import com.vortech.shapebuddybackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> findById(int id) {
        return this.userRepository.findById(id);
    }

    public void DeleteById(int id) {
        userRepository.deleteById(id);
    }

    public boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }

    public User loginUser(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username,password);
    }
}
