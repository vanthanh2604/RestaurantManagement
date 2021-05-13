package com.thanh.controller.backend;

import com.thanh.entity.KhuVucEntity;
import com.thanh.service.interf.KhuVucService;
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
@RequestMapping("/admin/khuvuc")
public class KhuVucController {
    @Autowired
    private KhuVucService khuVucService;
    @Autowired
    HttpSession session;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        if(session.getAttribute("username")!=null) {
            List<KhuVucEntity> listAll = khuVucService.get_All_KV();
            List<KhuVucEntity> listKV = khuVucService.get_limit(listAll,1,5);
            model.addAttribute("listKV",listKV);
            model.addAttribute("KhuVuc",new KhuVucEntity());
            model.addAttribute("tht",1);
            double tongsopage= Math.ceil((double)listAll.size()/5);
            model.addAttribute("tongsotrang",tongsopage);
            return "admin/danhSachKhuVuc";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "/list/page={i}", method = RequestMethod.GET)
    public String listLimit(@PathVariable("i")int i, Model model){
        if(session.getAttribute("username")!=null) {
            List<KhuVucEntity> listAll = khuVucService.get_All_KV();
            List<KhuVucEntity> listKV = khuVucService.get_limit(listAll,i,5);
            model.addAttribute("listKV",listKV);
            model.addAttribute("KhuVuc",new KhuVucEntity());
            model.addAttribute("tht",i);
            double tongsopage= Math.ceil((double)listAll.size()/5);
            model.addAttribute("tongsotrang",tongsopage);
            return "admin/danhSachKhuVuc";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String add_KV(@ModelAttribute("KhuVuc")KhuVucEntity khuvuc){
        khuVucService.add_KhuVuc(khuvuc);
        return "redirect:/admin/khuvuc/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete_KV(@PathVariable("id") int id){
        khuVucService.delete_KhuVuc(id);
        return "redirect:/admin/khuvuc/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit_SP(@PathVariable int id, Model model){
        model.addAttribute("KhuVuc",new KhuVucEntity());
        model.addAttribute("KhuVuc",khuVucService.get_KV_ById(id));
        return "admin/editKhuVuc";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update_SP(@ModelAttribute("KhuVuc") KhuVucEntity kv){
        khuVucService.update_KhuVuc(kv);
        return "redirect:/admin/khuvuc/list";
    }
}
