package com.malexj.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Registering the Login Action
 */
@Api(value = "/login", tags = "Tags")
@Slf4j
@Controller
public class LoginController
{
    /**
     * User authorization page
     *
     * @return `login` page
     */
    @ApiOperation(value = "Get `login.html` page", produces = "text/html")
    @GetMapping(value = "/login")
    public String loginPage()
    {
        return "login.html";
    }
}
