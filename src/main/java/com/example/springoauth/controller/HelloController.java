package com.example.springoauth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //controllador mvc
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/page1")
    public String pageOne(Model model) {
        model.addAttribute("message", "HOla mundo desde SPRING MVC!!");
        return "page1";
    }


    @GetMapping("/page2")
    public String pageTwo(
            Model model,
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OAuth2User user) {
        model.addAttribute("clientName", client.getClientRegistration().getClientName());
        model.addAttribute("userAttributes", user.getAttributes());
        model.addAttribute("userName", user.getName());
        model.addAttribute("message", "HOla mundo desde SPRING MVC!!");
        return "page2";
    }
}
