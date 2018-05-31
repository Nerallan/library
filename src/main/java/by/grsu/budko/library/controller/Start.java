package by.grsu.budko.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Start {
    // handles GET requests for / by returning the name of a View (hello)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getPage() {

        return "hello";
    }
}
