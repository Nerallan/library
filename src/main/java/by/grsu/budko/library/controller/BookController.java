//package by.grsu.budko.library.controller;
//
//import by.grsu.budko.library.model.Book;
//import by.grsu.budko.library.repository.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class BookController {
//    @Autowired
//    private BookRepository repository;
//
//    @RequestMapping("/table")
//    public ModelAndView doHome(){
//        ModelAndView mv = new ModelAndView("table");
//        mv.addObject("booklist",repository.findAll());
//        return mv;
//    }
//
//    @RequestMapping( value = "/save", method = RequestMethod.POST)
//    public ModelAndView doSave(@RequestParam("id") Long id, @RequestParam("book_title") String bookTitle, @RequestParam("book_author") String bookAuthor, @RequestParam("book_price") int bookPrice){
//        ModelAndView mv = new ModelAndView("redirect:/");
//        Book books;
//        if(!id.equals(0)){
//            books =(Book)repository.findOne(id);
//        } else {
//            books = new Book();
//        }
//        books.setBookTitle(bookTitle);
//        books.setBookAuthor(bookAuthor);
//        books.setBookPrice(bookPrice);
//        repository.save(books);
//        return mv;
//    }
//
//    @RequestMapping( value = "/view/{id}", method = RequestMethod.GET)
//    public ModelAndView doView(@PathVariable("id") Long id){
//        ModelAndView mv = new ModelAndView("view");
//        mv.addObject("lists",repository.findOne(id));
//        return mv;
//    }
//
//    @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView doDelete(@PathVariable("id") Long id){
//        ModelAndView mv = new ModelAndView("redirect:/");
//        repository.delete(id);
//        return mv;
//    }
//
//    @RequestMapping( value = "/edit/{id}", method = RequestMethod.GET)
//    public ModelAndView doEdit(@PathVariable("id") Long id){
//        ModelAndView mv = new ModelAndView("edit");
//        mv.addObject("lists",repository.findOne(id));
//        return mv;
//    }
//
//    @RequestMapping
//    public ModelAndView getBooks() {
//        return new ModelAndView("books", "booklist", repository.findAll());
//    }
//}