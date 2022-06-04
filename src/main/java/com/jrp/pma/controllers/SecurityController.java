package com.jrp.pma.controllers;

import com.jrp.pma.entities.UserAccount;
import com.jrp.pma.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    @Autowired
    UserAccountService userS;

    @GetMapping("/register")
    public String register(Model model){
        UserAccount account = new UserAccount();
        model.addAttribute("userAccount", account);

        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Model model, UserAccount user){
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        userS.save(user);
        return ("redirect:/");
    }


}
