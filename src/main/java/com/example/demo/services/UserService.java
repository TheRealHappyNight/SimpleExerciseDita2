package com.example.demo.services;

import com.example.demo.dtos.UserDTO;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        this.userRepository.createUser(user);
    }

    public void updateUser(UserDTO user) {
        this.userRepository.updateUser(user);
    }

    public User getUser(Integer index) {
        return this.userRepository.getUser(index);
    }

    public void deleteUser(Integer index) {
        this.userRepository.deleteUser(index);
    }
}
