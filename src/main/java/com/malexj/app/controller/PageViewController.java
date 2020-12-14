package com.malexj.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.malexj.app.constant.Constant.INDEX_HTML;

@Slf4j
@Controller
public class PageViewController
{
    /**
     * Processing of the main `index.html` page
     */
    @GetMapping(value = {"/"}, produces = "text/html")
    public String getBasePage()
    {
        return INDEX_HTML;
    }

    /**
     * Refresh UI part
     */
    @GetMapping(value = "/{page}", produces = "text/html")
    public String refreshUiPartForPages(@PathVariable("page") String page)
    {
        String msg = "Refresh page view - '%s'";
        log.debug(String.format(msg, page));
        return INDEX_HTML;
    }

    /**
     * Refresh UI part
     */
    @GetMapping(value = "/{page}/subcategories/{id}", produces = "text/html")
    public String refreshUiPartForSubcategories(@PathVariable("page") String page, @PathVariable("id") Integer id)
    {
        String msg = "Refresh page view - '%s' for subcategory id - %s";
        log.debug(String.format(msg, page, id));
        return INDEX_HTML;
    }
}
