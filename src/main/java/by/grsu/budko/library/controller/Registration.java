package by.grsu.budko.library.controller;

import by.grsu.budko.library.sql.SQL;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Registration {

    private SQL sql= new SQL("jdbc:mysql://localhost:3306/clients?useUnicode=true&characterEncoding=utf8","root","6431");

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
        public String getPage(){
        return "registrationPage";
    }

    @RequestMapping(value="/add-new-user", method = RequestMethod.POST)
    public String addNewUser(String name, String surname, String passwd, String login){
        //добавить проверку существования логина
        String str=String.format("insert into `clients` (`login`, `name`, `surname`, `passwd`) values ('%s', '%s', '%s', '%s')",login,name,surname,passwd);
        System.out.println(str);
        sql.changeLine(str);

        return "registrationPage";
    }




}
