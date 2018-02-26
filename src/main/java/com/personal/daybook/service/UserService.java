package com.personal.daybook.service;


import com.personal.daybook.dao.UserRepository;
import com.personal.daybook.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public String findUser(String username) {
        for (User user:userRepository.findAll()
                ) {
            if(user.getUsername().equals(username)){
                return user.getFirst_name();
            }
        }
        return "";
    }
}
