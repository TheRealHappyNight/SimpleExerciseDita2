package com.example.demo.repository;

import com.example.demo.dtos.UserDTO;
import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Integer, UserDTO> idUserMap = new HashMap<>();

    public void createUser(User user) {
        UserDTO userDTO = new UserDTO(user);
        this.idUserMap.put(userDTO.getUserId(), userDTO);
    }

    public void updateUser(UserDTO userDTO) {
        if (!this.idUserMap.containsKey(userDTO.getUserId())) {
            throw new IllegalArgumentException();
        }

        this.idUserMap.put(userDTO.getUserId(), userDTO);
    }

    public User getUser(Integer index) {
        if (!this.idUserMap.containsKey(index)) {
            throw new IllegalArgumentException();
        }

        return this.idUserMap.get(index).getUser();
    }

    public void deleteUser(Integer index) {
        if (!this.idUserMap.containsKey(index)) {
            throw new IllegalArgumentException();
        }

        this.idUserMap.remove(index);
    }
}
