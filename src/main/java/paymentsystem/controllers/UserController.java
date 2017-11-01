package paymentsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import paymentsystem.models.Transaction;
import paymentsystem.models.User;
import paymentsystem.services.TransactionService;
import paymentsystem.services.TransactionServiceImpl;
//import paymentsystem.services.TransactionService;
//import paymentsystem.services.TransactionServiceImpl;
import paymentsystem.services.UserService;
import paymentsystem.services.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    private UserService userService = new UserServiceImpl();
    private TransactionService transactionService = new TransactionServiceImpl();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String index() {
        return "startPage";
    }

    @RequestMapping(value = "/user/show_transactions", method = RequestMethod.GET)
    public ModelAndView showTransactions() {
        //TODO
        return new ModelAndView("showTransactions");
    }

    @RequestMapping(value = "/admin/show_transactions", method = RequestMethod.GET)
    public ModelAndView showAllTransactions() {
        List<Transaction> tr = transactionService.selectAll();
        ModelAndView m = new ModelAndView("showTransactions");
        m.addObject("transactions",tr);
        return m;
    }

    @RequestMapping(value = "/admin/show_users", method = RequestMethod.GET)
    public ModelAndView showAllUsers() {
        //TODO
        return new ModelAndView("showUsers");
    }

    @RequestMapping(value = "/admin/show_users/unblock/{id}", method = RequestMethod.GET)
    public String unblockUser(@PathVariable("id") int id ){
        //TODO
        return "redirect:/admin/show_users";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String indexAdmin() {
        return "startPageForAdmin";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String create(User user) {
        //userService.save(user);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
//    public String update(User user) {
    	public String update() {
        userService.save();
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/find/{id}", method = RequestMethod.GET)
    public ModelAndView findById(@PathVariable("id") long id) {
        User user = userService.findById(id);
        //TODO
        ModelAndView m = new ModelAndView("successfulFound");
        m.addObject("login", user.getLogin());
        return m;
    }

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") long id ) {
        userService.deleteById(id);
        //TODO
        return "redirect:/admin/";
    }
}
