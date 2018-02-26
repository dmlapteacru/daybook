package com.personal.daybook.controller;

import com.personal.daybook.data.Contact;
import com.personal.daybook.data.User;
import com.personal.daybook.service.ContactService;
import com.personal.daybook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;

    @GetMapping("/users")
    public List<Contact> showUsers(){
        return contactService.findAll();
    }
    @RequestMapping("/topics")
    public List<User> getAllTopics(){
        return userService.findAll();
    }
    /*@PostMapping("/topics")
    protected void add(@RequestBody User user){
        userService.addUser(user);
    }
    @PostMapping("/users")
    protected void addE(@RequestBody Contact contact){
        contactService.saveContact(contact);
    }*/
}
