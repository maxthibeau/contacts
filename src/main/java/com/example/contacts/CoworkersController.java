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
public class CoworkersController {

    @Autowired
    private CoworkerRepository coworkerRepository;

    @GetMapping("/coworkers/create")
    public String create(){
        return "coworkers/create";
    }

    @PostMapping("/coworkers/create")
    public RedirectView submit_create(@RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam String phoneNumber,
                                      @RequestParam String emailAddress){
        Coworker c = new Coworker();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setPhoneNumber(phoneNumber);
        c.setEmailAddress(emailAddress);
        coworkerRepository.save(c);
        return new RedirectView("/");
    }

    @GetMapping("/coworkers/update/{id}")
    public String update_form(Model model,
                              @PathVariable int id
    ){
        Optional<Coworker> cOptional =
                coworkerRepository.findById(id);
        Coworker c = cOptional.get();
        model.addAttribute("firstName", c.getFirstName());
        model.addAttribute("lastName", c.getLastName());
        model.addAttribute("phoneNumber", c.getPhoneNumber());
        model.addAttribute("emailAddress", c.getEmailAddress());
        return "coworkers/update";
    }

    @PostMapping("/coworkers/update/{id}")
    public RedirectView submit_update(@PathVariable int id,
                                      @RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam String phoneNumber,
                                      @RequestParam String emailAddress){
        Coworker c = new Coworker();
        c.setId(id);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setPhoneNumber(phoneNumber);
        c.setEmailAddress(emailAddress);
        coworkerRepository.save(c);
        return new RedirectView("/");
    }

    @GetMapping("/coworkers/delete/{id}")
    public RedirectView delete(@PathVariable int id){
        Optional<Coworker> coworkerOptional =
                coworkerRepository.findById(id);
        Coworker coworker = coworkerOptional.get();
        coworkerRepository.delete(coworker);
        return new RedirectView("/");
    }
}
