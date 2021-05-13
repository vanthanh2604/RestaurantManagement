package com.thanh.controller.backend;

import com.thanh.service.interf.BanAnService;
import com.thanh.service.interf.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class DashboardController {
    @Autowired
    private BanAnService banAnService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    HttpSession session;
    @RequestMapping("/dashboard")
    public String dashboard(Model model){
        if(session.getAttribute("username")!=null) {
            model.addAttribute("totalTable",banAnService.get_total_table());
            model.addAttribute("totalInvoice",hoaDonService.get_total_invoice());
            model.addAttribute("total_revenue",hoaDonService.total_revenue(hoaDonService.get_All()));
            return "/admin/index";
        } else { return "admin/404"; }
    }
}
