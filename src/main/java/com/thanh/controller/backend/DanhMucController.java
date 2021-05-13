package com.thanh.controller.backend;

import com.thanh.entity.TheLoaiEntity;
import com.thanh.service.interf.TheLoaiService;
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
@RequestMapping("/admin/danhmuc")
public class DanhMucController {
    @Autowired
    private TheLoaiService theLoaiService;
    @Autowired
    HttpSession session;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        if(session.getAttribute("username")!=null) {
            List<TheLoaiEntity> listAll = theLoaiService.get_All_TL();
            List<TheLoaiEntity> listTL = theLoaiService.get_limit(listAll,1,5);
            model.addAttribute("listTL",listTL);
            model.addAttribute("DanhMuc",new TheLoaiEntity());
            model.addAttribute("tht",1);
            double tongsopage= Math.ceil((double)listAll.size()/5);
            model.addAttribute("tongsotrang",tongsopage);
            return "admin/danhSachDanhMuc";
        }
        else {
            return "admin/404";
        }
    }
    @RequestMapping(value = "/list/page={i}", method = RequestMethod.GET)
    public String listLimit(@PathVariable("i") int i,Model model){
        if(session.getAttribute("username")!=null) {
            List<TheLoaiEntity> listAll = theLoaiService.get_All_TL();
            List<TheLoaiEntity> listTL = theLoaiService.get_limit(listAll,i,5);
            model.addAttribute("listTL",listTL);
            model.addAttribute("DanhMuc",new TheLoaiEntity());
            model.addAttribute("tht",1);
            double tongsopage= Math.ceil((double)listAll.size()/5);
            model.addAttribute("tongsotrang",tongsopage);
            return "admin/danhSachDanhMuc";
        } else { return "admin/404"; }

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String add_TL(@ModelAttribute("DanhMuc")TheLoaiEntity danhmuc){
        if(session.getAttribute("username")!=null) {
            theLoaiService.add_DanhMuc(danhmuc);
            return "redirect:/admin/danhmuc/list";
        } else { return "admin/404"; }

    }

    @RequestMapping(value = "/delete/{id}")
    public String delete_TL(@PathVariable("id") int id){
        if(session.getAttribute("username")!=null) {
            theLoaiService.delete_DanhMuc(id);
            return "redirect:/admin/danhmuc/list";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit_TL(@PathVariable int id, Model model){
        if(session.getAttribute("username")!=null) {
            model.addAttribute("DanhMuc",new TheLoaiEntity());
            model.addAttribute("DanhMuc",theLoaiService.get_TL_ById(id));
            return "admin/editDanhMuc";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update_TL(@ModelAttribute("DanhMuc") TheLoaiEntity tl){
        if(session.getAttribute("username")!=null) {
            theLoaiService.update_DanhMuc(tl);
            return "redirect:/admin/danhmuc/list";
        } else { return "admin/404"; }
    }
}
