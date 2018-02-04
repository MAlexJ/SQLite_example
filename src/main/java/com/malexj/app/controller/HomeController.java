package com.malexj.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class HomeController {
    /**
     * Home page
     *
     * @return `index` page
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage() {
        log.debug(">>> index.html");
        return "index.html";
    }
}
