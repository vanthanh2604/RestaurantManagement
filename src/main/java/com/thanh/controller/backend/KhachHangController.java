package com.thanh.controller.backend;

import com.thanh.entity.KhachHangEntity;
import com.thanh.service.interf.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("admin/khachhang")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    HttpSession session;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        if(session.getAttribute("username")!=null) {
            model.addAttribute("khachhang",new KhachHangEntity());
            model.addAttribute("listAll",khachHangService.get_All_KH());
            return "admin/danhSachKhachHang";
        } else { return "admin/404"; }

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("khachhang") KhachHangEntity kh){
        if(session.getAttribute("username")!=null) {
            khachHangService.addKhachHang(kh);
            return "redirect:/admin/khachhang/list";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete_KH(@PathVariable("id") int id){
        khachHangService.deleteKhachHang(id);
        return "redirect:/admin/khachhang/list";
    }
    @RequestMapping(value = "/edit/{id}")
    public String edit_KH(@PathVariable int id, Model model){
        model.addAttribute("khachhang",new KhachHangEntity());
        model.addAttribute("khachhang",khachHangService.get_KH_ById(id));
        return "admin/editKhachHang";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update_KH(@ModelAttribute("khachhang") KhachHangEntity kh){
        khachHangService.update_KH(kh);
        return "redirect:/admin/khachhang/list";
    }
}
