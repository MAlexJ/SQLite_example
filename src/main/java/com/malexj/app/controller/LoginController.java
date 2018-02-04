package com.malexj.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
        log.debug(">>> login.html");
        return "login.html";
    }
}