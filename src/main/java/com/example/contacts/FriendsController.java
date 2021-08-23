package com.example.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class FriendsController {

    @Autowired
    private FriendRepository friendRepository;

    @GetMapping("/friends/create")
    public String create(){
        return "friends/create";
    }

    @PostMapping("/friends/create")
    public RedirectView submit_create(@RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam String phoneNumber,
                                      @RequestParam String emailAddress,
                                      @RequestParam String birthDate){
        Friend f = new Friend();
        f.setFirstName(firstName);
        f.setLastName(lastName);
        f.setPhoneNumber(phoneNumber);
        f.setEmailAddress(emailAddress);
        f.setBirthDate(birthDate);
        friendRepository.save(f);
        return new RedirectView("/");
    }

    @GetMapping("/friends/update/{id}")
    public String update_form(Model model,
                              @PathVariable int id
    ){
        Optional<Friend> fOptional =
                friendRepository.findById(id);
        Friend f = fOptional.get();
        model.addAttribute("firstName", f.getFirstName());
        model.addAttribute("lastName", f.getLastName());
        model.addAttribute("phoneNumber", f.getPhoneNumber());
        model.addAttribute("emailAddress", f.getEmailAddress());
        model.addAttribute("birthDate", f.getBirthDate());
        return "friends/update";
    }

    @PostMapping("/friends/update/{id}")
    public RedirectView submit_update(@PathVariable int id,
                                      @RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam String phoneNumber,
                                      @RequestParam String emailAddress,
                                      @RequestParam String birthDate){
        Friend f = new Friend();
        f.setId(id);
        f.setFirstName(firstName);
        f.setLastName(lastName);
        f.setPhoneNumber(phoneNumber);
        f.setEmailAddress(emailAddress);
        f.setBirthDate(birthDate);
        friendRepository.save(f);
        return new RedirectView("/");
    }

    @GetMapping("/friends/delete/{id}")
    public RedirectView delete(@PathVariable int id){
        Optional<Friend> friendOptional =
                friendRepository.findById(id);
        Friend friend = friendOptional.get();
        friendRepository.delete(friend);
        return new RedirectView("/");
    }
}
