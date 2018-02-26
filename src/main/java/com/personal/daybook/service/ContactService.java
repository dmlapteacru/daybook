package com.personal.daybook.service;

import com.personal.daybook.dao.ContactRepository;
import com.personal.daybook.data.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll(){
       return contactRepository.findAll();
    }

    public void deleteContact(Long id) {
        contactRepository.delete(id);
    }

    public Contact getContactById(Long id) {
        return contactRepository.findOne(id);
    }

    public void saveContact(Contact newContact) {
        contactRepository.save(newContact);
    }

    public List<Contact> findAllByUser(String username){
        List<Contact> contactList = new ArrayList<>();
        for (Contact contact:contactRepository.findAll()
             ) {
            if(contact.getUser_name().equals(username))
            contactList.add(contact);
        }
        return contactList;
    }

}
