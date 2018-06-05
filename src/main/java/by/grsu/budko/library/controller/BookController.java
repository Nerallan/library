package by.grsu.budko.library.controller;

import by.grsu.budko.library.model.Book;
import by.grsu.budko.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    // return list of all books for editBooks page
    @RequestMapping("/editBooks")
    public ModelAndView editBook(){
        ModelAndView mv = new ModelAndView("editBooks");
        mv.addObject("booklist",repository.findAll());
        return mv;
    }

    // saving new input book into db
    @RequestMapping( value = "/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") Long id, @RequestParam("book_title") String bookTitle, @RequestParam("book_author") String bookAuthor, @RequestParam("book_price") int bookPrice){
        ModelAndView mv = new ModelAndView("redirect:/");
        Book books;
        if(!id.equals(0)){
            books =(Book)repository.findOne(id);
        } else {
            books = new Book();
        }
        books.setBookTitle(bookTitle);
        books.setBookAuthor(bookAuthor);
        books.setBookPrice(bookPrice);
        repository.save(books);
        return mv;
    }

    // go to view page of books
    @RequestMapping( value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("lists",repository.findOne(id));
        return mv;
    }

    // delete specific book
    @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/");
        repository.delete(id);
        return mv;
    }

    // edit specific book
    @RequestMapping( value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("lists",repository.findOne(id));
        return mv;
    }

    // return list of all books for books page
    @RequestMapping
    public ModelAndView getBooks() {
        return new ModelAndView("books", "booklist", repository.findAll());
    }
}