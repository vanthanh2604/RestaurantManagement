package com.thanh.controller.backend;

import com.thanh.entity.NhanVienEntity;
import com.thanh.service.interf.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    HttpSession session;
    @Autowired
    NhanVienService nhanVienService;
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String login(){
        return "admin/login";
    }
    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    public String result(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         ModelMap modelMap){

        if(nhanVienService.getNV(username,password)!=null) {
            session.setAttribute("username", username);
            return "redirect:/admin/dashboard";
        } else {
            modelMap.put("error", "Invalid Account");
            return "admin/login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/admin";
    }
}
