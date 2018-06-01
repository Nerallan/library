package by.grsu.budko.library.controller;

import by.grsu.budko.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository repository;

    @RequestMapping
    public ModelAndView getSuperheroes() {
        return new ModelAndView("books", "books", repository.findAll());
    }
}