package com.thanh.controller.frontend;

import com.thanh.dto.LienHeDTO;
import com.thanh.entity.KhachHangEntity;
import com.thanh.service.interf.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/account")
public class Login1Controller {
    @Autowired
    HttpSession session;
    @Autowired
    KhachHangService khachHangService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login1(){
        return "user/login1";
    }
    @RequestMapping(value = "/checklogin",method = RequestMethod.POST)
    public String result(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         ModelMap modelMap){
        KhachHangEntity k=khachHangService.kh(email,password);
        if(khachHangService.kh(email,password)!=null) {
            session.setAttribute("email", email);
            session.setAttribute("idUser",k.getId());
            modelMap.put("success", "Đăng nhập thành công!");
            return "user/login1";
        } else {
            modelMap.put("error", "Invalid Account");
            return "user/login1";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/login";
    }
}
