package com.thanh.controller.backend;

import com.thanh.entity.ChiTietHoaDonEntity;
import com.thanh.entity.HoaDonEntity;
import com.thanh.service.interf.ChiTietHoaDonService;
import com.thanh.service.interf.DonDatBanService;
import com.thanh.service.interf.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/dondatban")
public class DonDatBanController {
    @Autowired
    private DonDatBanService donDatBanService;
    @Autowired
    ChiTietHoaDonService chiTietHoaDonService;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    HttpSession session;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listChuaDuyet(Model model)
    {
        if(session.getAttribute("username")!=null) {
            model.addAttribute("list",donDatBanService.getListChuaDuyet());
            return "admin/danhSachDonDatBan";
        } else { return "admin/404"; }
    }
    @RequestMapping(value = "/list/duyet", method = RequestMethod.GET)
    public String listDuyet(Model model)
    {
        if(session.getAttribute("username")!=null) {
        model.addAttribute("list",donDatBanService.getListDaDuyet());
        return "admin/danhSachDonDatBan";
        } else { return "admin/404"; }
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
        if(session.getAttribute("username")!=null) {
            donDatBanService.delete(id);
        int idhd=donDatBanService.get_by_Id(id).getIdHD();
            HoaDonEntity hd=hoaDonService.get_byId(idhd);
            chiTietHoaDonService.delete_By_IdHd(hd.getId());
            hoaDonService.deleteById(hd.getId());
            return "redirect:/admin/dondatban/list";
        } else { return "admin/404"; }
    }
    @ResponseBody
    @RequestMapping(value = "/xuly/{id}/{idHd}", method = RequestMethod.GET)
    public Object xuly(@PathVariable("id") Integer id,@PathVariable("idHd")Integer idHd) {
        if(session.getAttribute("username")!=null) {
        donDatBanService.update_status(id,idHd);
        Object[] info={"Đã duyệt"};
        return info;
        } else { return "admin/404"; }
    }
    @RequestMapping(value = "/detail/{idHd}", method = RequestMethod.GET)
    public String order_detail(@PathVariable("idHd") Integer id, Model model){
        if(session.getAttribute("username")!=null) {
        HoaDonEntity hd=hoaDonService.get_byId(id);
        List<ChiTietHoaDonEntity> list=chiTietHoaDonService.get_CTHD(id);
        model.addAttribute("total",hd.getTongTien());
        model.addAttribute("list",list);
        return "admin/chiTietDonDatBan";
        } else { return "admin/404"; }
    }
}
