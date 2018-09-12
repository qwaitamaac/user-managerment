package com.seven.usermanagement.controllers;

import com.seven.usermanagement.dto.UserDTO;
import com.seven.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @GetMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("user", new UserDTO());//oject user binding data
        return mav;
    }
    @PostMapping(value = "/login-process")
    public ModelAndView LoginProcess(UserDTO user){
        System.out.println(user);//print user
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/");//redirect to home
        return mav;
    }

    @GetMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("register", new UserDTO());
        return mav;
    }
    @PostMapping(value = "/register-process")
    public ModelAndView registerProcess(UserDTO userDTO){

        System.out.println(userDTO);//print user
        userService.createUser(userDTO);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/login");//redirect to home
        return mav;
    }
    @GetMapping(value = "/list")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("List");
        mav.addObject("register", new UserDTO());
        return mav;
    }
}
