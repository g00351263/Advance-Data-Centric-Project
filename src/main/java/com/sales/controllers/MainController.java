//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //
//This is to manage the login and index page

package com.sales.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @GetMapping("/success")
    public String succ(Model model) {
        return "index2";
    }
}
