package com.malexj.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Registering the Login Action
 */
@Slf4j
@Controller
public class LoginController {
    /**
     * User authorization page
     *
     * @return `login` page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login.html";
    }

    /**
     * Login form with error
     *
     * @return `login` page
     */
    @RequestMapping(value = "/login-error", method = RequestMethod.GET)
    public String loginErrorPage(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
}