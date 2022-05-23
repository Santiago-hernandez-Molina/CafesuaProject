package com.usta.cafesua.controllers;

import com.usta.cafesua.entities.UserCafesua;
import com.usta.cafesua.models.services.IUser;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUser iUser;

    @RequestMapping(value="/userRegister", method = RequestMethod.GET)
    public String saveUserGet(@Valid UserCafesua userCafesua, BindingResult result, Model model) {
        return "register";
    }

    @RequestMapping(value="/userRegister", method = RequestMethod.POST)
    public String savePlace(@Valid UserCafesua userCafesua, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        iUser.saveUser(userCafesua);
        return "redirect:/home";
    }
}
