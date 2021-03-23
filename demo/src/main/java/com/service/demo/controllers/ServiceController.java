package com.service.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ServiceController {


    @GetMapping("/home")
    public String main(Model model) {
        model.addAttribute("message", "message");
        model.addAttribute("tasks", "tasks");

        return "index"; //view
    }

    @GetMapping("/register")
    public String registration(Model model, HttpServletRequest request) {
        model.addAttribute("message", "message");
        model.addAttribute("tasks", "tasks");

        return "registration"; //view
    }
    @GetMapping("/addCar")
    public String addCar(Model model, HttpServletRequest request) {
        model.addAttribute("message", "message");
        model.addAttribute("tasks", "tasks");

        return "addCar"; //view
    }

    @GetMapping("/addBike")
    public String addBike(Model model, HttpServletRequest request) {
        model.addAttribute("message", "message");
        model.addAttribute("tasks", "tasks");

        return "addBike"; //view
    }



}
