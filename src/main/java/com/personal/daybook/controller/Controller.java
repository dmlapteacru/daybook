package com.personal.daybook.controller;


import com.personal.daybook.data.Contact;
import com.personal.daybook.data.User;
import com.personal.daybook.service.ContactService;
import com.personal.daybook.service.UserService;
import com.skype.Skype;
import com.skype.SkypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;


    @GetMapping("/contacts")
    public String ContactsList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", userService.findUser(name));
        model.addAttribute("contactsList", contactService.findAllByUser(name));
        return "contacts";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String ContactSubmitDelete(@RequestParam Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

    @GetMapping("/edit")
    public String ContactEdit(@RequestParam Long id, Model model){
        if(id != null){
            model.addAttribute("updateContact", contactService.getContactById(id));
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            model.addAttribute("updateContact", new Contact(name));
        }

        return "edit";
    }

    @PostMapping("/edit")
    public String ContactsEdit(@ModelAttribute Contact newContact){
        contactService.saveContact(newContact);
        return "redirect:/contacts";
    }

    /**/
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String newUser(@ModelAttribute User newUser){
        userService.saveUser(newUser);
        return "login";
    }

    @RequestMapping("call")
    public String makeCall(@RequestParam String skype){
        try {
            Skype.call(skype);
        } catch (SkypeException e) {
            e.printStackTrace();
        }
        return "redirect:contacts";
    }
}
