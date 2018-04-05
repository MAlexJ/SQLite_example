package com.malexj.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Registering the Login Action
 */
@Slf4j
@Controller
@Api(value = "/login", description = "Show login page")
public class LoginController
{
    /**
     * User authorization page
     *
     * @return `login` page
     */
    @ApiOperation(value = "Get `login.html` page", produces = "text/html")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage()
    {
        return "login.html";
    }
}
