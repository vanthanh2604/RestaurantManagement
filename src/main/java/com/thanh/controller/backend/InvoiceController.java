package com.thanh.controller.backend;

import com.thanh.service.interf.ChiTietHoaDonService;
import com.thanh.service.interf.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/admin/invoice")
public class InvoiceController {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;
    @Autowired
    HttpSession session_user;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list_Product(Model model){
        if(session_user.getAttribute("username")!=null) {
            model.addAttribute("list",hoaDonService.get_All());
            return "admin/danhSachHoaDon";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String invoice_detail(@PathVariable("id")Integer id, Model model){
        if(session_user.getAttribute("username")!=null) {
            model.addAttribute("list",chiTietHoaDonService.get_CTHD(id));
            model.addAttribute("hoaDon",hoaDonService.get_byId(id));
            return "admin/chiTietHD";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "/back",method = RequestMethod.GET)
    public String back_invoice_detail(){
        return "redirect:/admin/invoice/list";
    }
}
