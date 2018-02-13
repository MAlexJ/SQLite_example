package com.malexj.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class PageViewController {
    /**
     * Index page
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage() {
        return "index.html";
    }

    /**
     * Index page
     */
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String page(@PathVariable("page") String page) {
        return "index.html";
    }

    /**
     * DDL page
     */
    @RequestMapping(value = "/app/ddl", method = RequestMethod.GET, produces = "text/html")
    public String ddlPage() {
        return "app/ddl/ddl.html";
    }

    /**
     * DML page
     */
    @RequestMapping(value = "/app/dml", method = RequestMethod.GET, produces = "text/html")
    public String dmlPage() {
        return "app/dml/dml.html";
    }

    /**
     * TCL page
     */
    @RequestMapping(value = "/app/tcl", method = RequestMethod.GET, produces = "text/html")
    public String tclPage() {
        return "app/tcl/tcl.html";
    }
}
