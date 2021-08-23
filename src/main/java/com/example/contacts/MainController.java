package com.example.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private CoworkerRepository coworkerRepository;

    @Autowired
    private FriendRepository friendRepository;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("contacts", contactRepository.findAll());
        model.addAttribute("coworkers", coworkerRepository.findAll());
        model.addAttribute("friends", friendRepository.findAll());
        return "home";
    }
}
