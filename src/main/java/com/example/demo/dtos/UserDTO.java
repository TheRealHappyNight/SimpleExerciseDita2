package com.example.demo.dtos;

import com.example.demo.models.User;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDTO {
    private static final AtomicInteger currentUserId = new AtomicInteger(1);
    private int userId;
    private User user;

    public UserDTO(User user) {
        this.userId = currentUserId.getAndIncrement();
        this.user = new User(user);
    }

    public UserDTO(int id, User user) {
        this.userId = id;
        this.user = new User(user);
    }

    public int getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(UserDTO userDTO) {
        this.userId = userDTO.userId;
        this.user = new User(userDTO.user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return userId == userDTO.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", user=" + user +
                '}';
    }
}
