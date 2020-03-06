package org.zone.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zone.entity.User;
import org.zone.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
public class UserController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginpage(HttpSession session)
    {   session.invalidate();
        return "login";
    }
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String check(Model model, @RequestParam("username")String username, @RequestParam("password")String password,
                        RedirectAttributes attr, HttpSession session, HttpServletResponse response){

       try {
           User user=userService.login(username,password);
           if(user==null)
           {
               attr.addFlashAttribute("error","账号或密码错误！");
               logger.error("账号或密码错误！");
               return "redirect:/login";
           }
           else{
               session.setAttribute("user",user);
               Cookie cookieSId = new Cookie("JSESSIONID",session.getId());
               cookieSId.setMaxAge(60*60);
               cookieSId.setPath("/");
               response.addCookie(cookieSId);
               return "redirect:/zone/"+username;
           }
       }catch (Exception e)
       {
          logger.error(e.getMessage());
       }
        return null;
    }

}
