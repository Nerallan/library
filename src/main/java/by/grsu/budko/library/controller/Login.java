package by.grsu.budko.library.controller;

import by.grsu.budko.library.sql.SQL;
import by.grsu.budko.library.types.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class Login {

    private SQL sql = new SQL("jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=utf8", "root", "6431");


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getPage(){
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String  login(String login, String passwd, HttpSession session) {
        String query = String.format("select `id`,`name`,`surname`, `passwd` from `clients` where `login`='%s'", login);
        if (sql.getLines(query, 4).size() == 1) {
            String[] split = sql.getLines(query, 4).get(0).split(";");
            if (split[3].equals(passwd)) {
                Client client = new Client(Integer.parseInt(split[0]), split[1], split[2], split[3],login);
                session.setAttribute("Client", client);

            }
        }

    return "infoPage";
    }
}
