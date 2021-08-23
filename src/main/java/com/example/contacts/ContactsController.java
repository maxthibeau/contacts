package com.example.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contacts/create")
    public String create(){
        return "/contacts/create";
    }

    @PostMapping("/contacts/create")
    public RedirectView submit_create(@RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam String phoneNumber){
        Contact c = new Contact();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setPhoneNumber(phoneNumber);
        contactRepository.save(c);
        return new RedirectView("/");
    }

    @GetMapping("/contacts/update/{id}")
    public String update_form(Model model,
                                    @PathVariable int id
                                    ){
        Optional<Contact> cOptional = contactRepository.findById(id);
        Contact c = cOptional.get();
        model.addAttribute("firstName", c.getFirstName());
        model.addAttribute("lastName", c.getLastName());
        model.addAttribute("phoneNumber", c.getPhoneNumber());
        return "contacts/update";
    }

    @PostMapping("/contacts/update/{id}")
    public RedirectView submit_update(@PathVariable int id,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String phoneNumber){
        Contact c = new Contact();
        c.setId(id);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setPhoneNumber(phoneNumber);
        contactRepository.save(c);
        return new RedirectView("/");
    }

    @GetMapping("/contacts/delete/{id}")
    public RedirectView delete(@PathVariable int id){
        Optional<Contact> contactOptional =
                contactRepository.findById(id);
        Contact contact = contactOptional.get();
        contactRepository.delete(contact);
        return new RedirectView("/");
    }
}
