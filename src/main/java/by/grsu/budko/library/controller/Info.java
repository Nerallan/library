package by.grsu.budko.library.controller;

import by.grsu.budko.library.sql.SQL;
import by.grsu.budko.library.types.Account;
import by.grsu.budko.library.types.Card;
import by.grsu.budko.library.types.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Info {

    private SQL sql = new SQL("jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=utf8", "root", "6431");

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getPage(HttpSession session, Model model) {
        if (session.getAttribute("Client") != null) {
            Client client = (Client) session.getAttribute("Client");
            model.addAttribute("name", client.getName());
            model.addAttribute("surname", client.getSurname());

            String query = String.format("select `id`,`balance`,`active` from `accounts` where `id_client`='%s'", client.getId());
            List<String> tempList = sql.getLines(query, 3);
            List<Account> accounts = new ArrayList<>();
            for (String str : tempList) {
                String[] split = str.split(";");
                Account account = new Account(Integer.parseInt(split[0]), Double.parseDouble(split[1]), client.getId(), split[2].equals("1"));
                if (account.isActive()) {
                    accounts.add(account);
                }
            }

            return "info";
        }
        return "redirect:/";

    }



}



