package com.thanh.controller.frontend;

import com.thanh.dto.DonDatBanDTO;
import com.thanh.entity.ChiTietHoaDonEntity;
import com.thanh.entity.HoaDonEntity;
import com.thanh.entity.KhachHangEntity;
import com.thanh.entity.SanPhamEntity;
import com.thanh.service.implement.Cart.CartService;
import com.thanh.service.interf.ChiTietHoaDonService;
import com.thanh.service.interf.DonDatBanService;
import com.thanh.service.interf.HoaDonService;
import com.thanh.service.interf.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class DatBanController {
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    DonDatBanService donDatBanService;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    ChiTietHoaDonService chiTietHoaDonService;
    @Autowired
    CartService cart;
    @Autowired
    HttpSession session;
    DonDatBanDTO dto =null;
    @RequestMapping(value = "/datban",method = RequestMethod.POST)
    public String datban(@ModelAttribute("dondatban") DonDatBanDTO don, Model model){
        if(session.getAttribute("email")!=null) {
            dto = don;
            model.addAttribute("dondatban", dto);
            return "user/xacnhan";
        }
        else{ return "user/login1";}
    }

    @RequestMapping(value = "/datban/xacnhan",method = RequestMethod.GET)
    public String xacnhan(Model model){
        if(session.getAttribute("email")!=null) {
            KhachHangEntity kh=khachHangService.get_KH_ById((int)session.getAttribute("idUser"));
            HoaDonEntity hd = hoaDonService.create(kh,3);
            dto.setIdHD(hd.getId());
            Collection<SanPhamEntity> list = cart.getItems();
            List<ChiTietHoaDonEntity> cthd = new ArrayList<>();
            for (SanPhamEntity item : list
            ) {
                ChiTietHoaDonEntity ct = new ChiTietHoaDonEntity();
                ct.setHoaDonEntity(hd);
                ct.setSanPhamEntity(item);
                ct.setSoLuong(item.getSoLuong());
                ct.setThanhTien();
                cthd.add(ct);
            }
            chiTietHoaDonService.create(cthd);
            hoaDonService.update_Hd(hd.getId());
            donDatBanService.create(dto);
            cart.clear();
            dto = null;
            return "redirect:/";
        }
        else{ return "user/login1";}
    }
}
