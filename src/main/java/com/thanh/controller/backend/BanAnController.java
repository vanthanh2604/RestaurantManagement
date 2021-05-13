package com.thanh.controller.backend;

import com.thanh.dto.BanDTO;
import com.thanh.entity.BanAnEntity;
import com.thanh.entity.KhuVucEntity;
import com.thanh.service.interf.BanAnService;
import com.thanh.service.interf.KhuVucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/ban")
public class BanAnController {
    @Autowired
    private BanAnService banAnService;
    @Autowired
    private KhuVucService khuVucService;
    @Autowired
    HttpSession session;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
//        String a= (String) session_user.getAttribute("username");
//        System.out.println(a);

        if(session.getAttribute("username")!=null) {
            List<BanAnEntity> listAll = banAnService.get_All_Ban();
            List<BanAnEntity> listBan = banAnService.get_limit(listAll, 1, 5);
            List<String> listKV = khuVucService.get_All_KV_Name();
            model.addAttribute("listKV", listKV);
            model.addAttribute("listBan", listBan);
            model.addAttribute("Ban", new BanDTO());
            model.addAttribute("tht", 1);
            double tongsopage = Math.ceil((double) listAll.size() / 5);
            model.addAttribute("tongsotrang", tongsopage);
            return "admin/danhSachBan";
        }
        else {
            return "admin/404";
        }

    }
    @RequestMapping(value = "/list/page={i}", method = RequestMethod.GET)
    public String listLimit(@PathVariable("i") int i, Model model){
        if(session.getAttribute("username")!=null) {
            List<BanAnEntity> listAll = banAnService.get_All_Ban();
            List<BanAnEntity> listBan = banAnService.get_limit(listAll,i,5);
            List<String>listKV= khuVucService.get_All_KV_Name();
            model.addAttribute("listKV",listKV);
            model.addAttribute("listBan",listBan);
            model.addAttribute("Ban",new BanDTO());
            model.addAttribute("tht",i);
            double tongsopage= Math.ceil((double)listAll.size()/5);
            model.addAttribute("tongsotrang",tongsopage);
            return "admin/danhSachBan";
        }
        else {
            return "admin/404";
        }

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String add_Ban(@ModelAttribute("Ban") BanDTO ban){
        if(session.getAttribute("username")!=null) {
            BanAnEntity banAnEntity=new BanAnEntity();
            banAnEntity.setTenBanAn(ban.getTenBanAn());
            banAnEntity.setTrangThai(ban.getTrangThai());
            banAnEntity.setKhuVucEntity(khuVucService.get_KV_ByName(ban.getKhuVuc()));
            banAnService.add_Ban(banAnEntity);
            return "redirect:/admin/ban/list";
        }
        else {
            return "admin/404";
        }

    }

    @RequestMapping(value = "/delete/{id}")
    public String delete_Ban(@PathVariable("id") int id){
        if(session.getAttribute("username")!=null) {
            banAnService.delete_Ban(id);
            return "redirect:/admin/ban/list";
        }
        else {
            return "admin/404";
        }

    }

    @RequestMapping(value = "/edit/{id}")
    public String edit_Ban(@PathVariable int id, Model model){
        if(session.getAttribute("username")!=null) {
            model.addAttribute("Ban",new BanDTO());
            List<String>listKV= khuVucService.get_All_KV_Name();
            model.addAttribute("listKV",listKV);
            BanAnEntity banAnEntity=banAnService.get_BanById(id);
            BanDTO banDTO =new BanDTO();
            banDTO.setId(banAnEntity.getId());
            banDTO.setTenBanAn(banAnEntity.getTenBanAn());
            banDTO.setTrangThai(banAnEntity.getTrangThai());
            banDTO.setKhuVuc(banAnEntity.getKhuVucEntity().getTenKV());

            model.addAttribute("Ban", banDTO);
            return "admin/editBan";
        }
        else {
            return "admin/404";
        }


    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update_Ban(@ModelAttribute("Ban") BanDTO banDTO){
        if(session.getAttribute("username")!=null) {
            KhuVucEntity khuVucEntity= khuVucService.get_KV_ByName(banDTO.getKhuVuc());
            banAnService.update_Ban(banDTO,khuVucEntity);
            return "redirect:/admin/ban/list";
        }
        else {
            return "admin/404";
        }

    }
}
