package com.thanh.controller.backend;

import com.thanh.service.interf.LienHeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/lienhe")
public class LienHeController {
    @Autowired
    private LienHeService lienHeService;
//    @Autowired
//    HttpSession session;
    @RequestMapping(value = "/list")
    public String list(Model model){
//        if(session.getAttribute("username")!=null) {
            model.addAttribute("list",lienHeService.get_All());
            return "admin/danhSachLienHe";
//        } else { return "admin/403"; }
    }
}
