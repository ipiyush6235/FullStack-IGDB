package com.company.project.signup.service;

import com.company.project.signup.model.User;
import com.company.project.signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    static List<User> users= new ArrayList<>();

    public List<User> getAllUsers() {
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }
    public User getUserInfo(String email){
        return users.stream().filter(s -> s.getName().equals(email)).findFirst().get();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public void editUser(String email, User updatedUser)
    {
        userRepository.deleteById(email);
        userRepository.save(updatedUser);
    }

    public void deleteUser(String email)
    {
        userRepository.deleteById(email);

    }
}
