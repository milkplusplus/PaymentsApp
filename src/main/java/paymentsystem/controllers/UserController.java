package paymentsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    //private UserService userService;

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
        //TODO
        return new ModelAndView("showTransactions");
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
    public String create(HttpServletRequest request /*UserForm userForm)*/) {
        /*String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String surName = request.getParameter("surName");
        ModelAndView m = new ModelAndView("successfulCreate");
        m.addObject("firstName", firstName);
        m.addObject("lastName", lastName);
        m.addObject("surName", surName);
        */
        // userService.save(userForm);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public String update(HttpServletRequest request /*UserForm userForm)*/) {
        // userService.save(userForm);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/find", method = RequestMethod.GET)
    public ModelAndView findById(HttpServletRequest request /*UserForm userForm)*/) {
        // userService.findUserById(id);
        ModelAndView m = new ModelAndView("successfulFound");
        //m.addObject("id", Integer.toString(id));
        return m;
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public String deleteById(HttpServletRequest request /*UserForm userForm)*/ ) {
        //userService.deleteUserById(id);
        return "redirect:/admin/";
    }
}
