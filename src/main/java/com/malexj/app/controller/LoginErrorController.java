package com.malexj.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Registering the Login Action
 */
@Api(value = "/login-error", description = "Show login page with error message")
@Slf4j
@Controller
public class LoginErrorController
{
    /**
     * Login form with error
     *
     * @return `login` page with error message
     */
    @ApiOperation(value = "Get `login.html` page with error message", produces = "text/html")
    @GetMapping(value = "/login-error")
    public String loginErrorPage(Model model)
    {
        model.addAttribute("loginError", true);
        return "login.html";
    }
}
