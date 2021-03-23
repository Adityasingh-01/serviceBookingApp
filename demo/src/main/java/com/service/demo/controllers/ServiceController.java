package com.service.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {


    @GetMapping("/home")
    public String main(Model model) {
        model.addAttribute("message", "message");
        model.addAttribute("tasks", "tasks");

        return "index"; //view
    }



}
