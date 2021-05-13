package com.thanh.controller.backend;

import com.thanh.entity.NhaCungCapEntity;
import com.thanh.service.interf.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/ncc")
public class NhaCungCapController {
    @Autowired
    NhaCungCapService nhaCungCapService;
    @Autowired
    HttpSession session;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        if(session.getAttribute("username")!=null) {
            model.addAttribute("nhacungcap",new NhaCungCapEntity());
            model.addAttribute("list_All",nhaCungCapService.get_All_NCC());
            return "admin/danhSachNCC";
        } else { return "admin/404"; }
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("khachhang") NhaCungCapEntity ncc){
        nhaCungCapService.add_NCC(ncc);
        return "redirect:/admin/ncc/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete_NCC(@PathVariable("id") int id){
        nhaCungCapService.delete_NCC(id);
        return "redirect:/admin/ncc/list";
    }
    @RequestMapping(value = "/edit/{id}")
    public String edit_NCC(@PathVariable int id, Model model){
        model.addAttribute("nhacungcap",new NhaCungCapEntity());
        model.addAttribute("nhacungcap",nhaCungCapService.get_NCC_ByID(id));
        return "admin/editNhaCungCap";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update_NCC(@ModelAttribute("nhacungcap") NhaCungCapEntity ncc){
        nhaCungCapService.update_NCC(ncc);
        return "redirect:/admin/ncc/list";
    }
}
