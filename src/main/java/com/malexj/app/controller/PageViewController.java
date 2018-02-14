package com.malexj.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.malexj.app.constant.Constant.*;

@Slf4j
@Controller
public class PageViewController {
    /**
     * Index page
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET, produces = "text/html")
    public String homePage() {
        return INDEX_HTML;
    }

    /**
     * any page
     */
    @RequestMapping(value = "/{page}", method = RequestMethod.GET, produces = "text/html")
    public String page(@PathVariable("page") String page) {
        return INDEX_HTML;
    }

    /**
     * app page
     */
    @RequestMapping(value = "/app/{category}", method = RequestMethod.GET, produces = "text/html")
    public String applPage(@PathVariable("category") String category) {
        switch (category) {
            case SUB_DDL:
            case SUB_DML:
            case SUB_TCL:
                return String.format(PATCH_TO_TEMPLATE, category, category);
            default:
                return INDEX_HTML;
        }
    }
}
