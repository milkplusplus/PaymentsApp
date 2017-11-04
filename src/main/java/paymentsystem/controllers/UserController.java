package paymentsystem.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import paymentsystem.forms.ListUserForm;
import paymentsystem.forms.UserRow;
import paymentsystem.models.Transfer;
import paymentsystem.models.User;
import paymentsystem.services.TransactionService;
import paymentsystem.services.TransactionServiceImpl;
//import paymentsystem.services.TransactionService;
//import paymentsystem.services.TransactionServiceImpl;
import paymentsystem.services.UserService;
import paymentsystem.services.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedList;
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
        return new ModelAndView("showTransactions");
    }

    @RequestMapping(value = "/admin/show_transactions", method = RequestMethod.GET)
    public ModelAndView showAllTransactions() {
        List<Transfer> tr = transactionService.selectAll();
        ModelAndView m = new ModelAndView("showTransactions");
        m.addObject("transactions",tr);
        return m;
    }

    @RequestMapping(value = "/admin/show_users", method = RequestMethod.GET)
    public ModelAndView showAllUsers() {
    	ModelAndView m = new ModelAndView("showUsers");
    	List<User> users = new LinkedList<User>();
    	try {
    		users = userService.selectAll();			
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
			//m.addObject("error", e.getMessage()); ///////////////////////////////////////////////????????
			return m;
		}
        m.addObject("users",users);
        return m;
    }

    @RequestMapping(value = "/admin/show_clients/unblock/{id}", method = RequestMethod.GET)
    public String unblockUser(@PathVariable("id") int id ){
        //TODO
        return "redirect:/admin/show_users";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String indexAdmin() {
        return "startPageForAdmin";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public ModelAndView createByAdmin() {
        ModelAndView m = new ModelAndView("createUserByAdmin");
        return m;
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public String submitCreateByAdmin(Model m, @ModelAttribute("user") User user) {
        System.out.println(user.getLogin() + " " + user.getPassword() + " " + user.getIs_admin());;
        try {
            userService.save(user);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            m.addAttribute("error", e.getMessage());
            return "createUserByAdmin";
        }
        return "redirect:/admin/show_users";
    }

    @RequestMapping(value = "/admin/update/{id}", method = RequestMethod.GET)
    	public String update(@PathVariable("id") long id) {
        //userService.save();
        return "redirect:/admin/show_users";
    }

    @RequestMapping(value = "/admin/find/{login}", method = RequestMethod.GET)
    public ModelAndView findByLog(@PathVariable("login") String log) {
    	User user = new User();
        ModelAndView m = new ModelAndView("successfulFound");
    	try {
    		user = userService.findByLog(log);			
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
			//m.addObject("login", e.getMessage());	///////////////////////////////////////////////????????
			return m;
		}
    	m.addObject("login", user.getLogin());			
        return m;
    }

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") long id ) {

        try {
        	userService.deleteById(id);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            //m.addAttribute("error", e.getMessage()); ///////////////////////////////////////////////????????
            return "createUserByAdmin";
        }
        return "redirect:/admin/show_users";  
        
        
        
    }


    @RequestMapping(value = "/admin/delete_users")
    public ModelAndView delete(HttpServletRequest request) {
        List<User> users = userService.selectAll();
        List <UserRow>  ur = new ArrayList<UserRow>();
        for (User u: users) {
            ur.add(new UserRow(u));
        }
        ListUserForm l = new ListUserForm();
        l.setList(ur);
        return new ModelAndView("delsession hibernateeteUsers","ListUserForm",l);
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute("ListUserForm") ListUserForm listUserForm, BindingResult result) {
        //TODO
        try{
        List<UserRow>  selectedList = listUserForm.getList();
            List<Long> id = new ArrayList();
            for (UserRow ur : selectedList) {
                if (ur.isCheckControl() == false) {
                    id.add(ur.getUser().getId());
                }
            }
            System.out.println(selectedList);
            for (int i = 0; i < id.size(); i++) {
                userService.deleteById(id.get(i));
            }
        } catch(Exception e){}
        return "redirect:/admin/delete_users";
    }
}
