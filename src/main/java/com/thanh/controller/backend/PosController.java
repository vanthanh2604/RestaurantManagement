package com.thanh.controller.backend;

import com.thanh.dto.SearchDTO;
import com.thanh.entity.*;
import com.thanh.service.interf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/pos")
public class PosController {
    @Autowired
    private BanAnService banAnService;
    @Autowired
    private KhuVucService khuVucService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private BanAnHoaDonService banAnHoaDonService;
    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;
    @Autowired
    DonDatBanService donDatBanService;
    @Autowired
    HttpSession session;
    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public String pos(Model model){
        if(session.getAttribute("username")!=null) {
            model.addAttribute("listBan",banAnService.get_All_Ban());
            model.addAttribute("listKV",khuVucService.get_All_KV());
            model.addAttribute("search",new SearchDTO());
            model.addAttribute("mode",0);
            return "admin/pos/pos";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "/table/search", method = RequestMethod.POST)
    public String search_table(@ModelAttribute("search") SearchDTO searchDTO, Model model){
        if(searchDTO.getString()==""){
            return "redirect:/admin/pos/table";
        }
        else {
            model.addAttribute("listBan",banAnService.search(searchDTO.getString()));
            model.addAttribute("listKV",khuVucService.get_All_KV());
            model.addAttribute("search",new SearchDTO());
            model.addAttribute("mode",0);
            return "admin/pos/pos";
        }
    }

    @RequestMapping(value = "/list-product/table/{id}",method = RequestMethod.GET)
    public String list_Product(@PathVariable("id")int id, Model model){
        List<SanPhamEntity>listAll = sanPhamService.get_All_SP();
        model.addAttribute("listSP",listAll);
        model.addAttribute("table",banAnService.get_BanById(id));
        model.addAttribute("search",new SearchDTO());
        return "admin/pos/danhSachSanPhamPos";
    }

    @ResponseBody
    @RequestMapping(value = "/add/table={idBan}&product={idSP}")
    public Object[] add_to_order(@PathVariable("idBan") Integer idBan,@PathVariable("idSP") Integer idSP){
        SanPhamEntity sp=sanPhamService.get_SanPhamById(idSP);
        BanAnEntity ban=banAnService.get_BanById(idBan);
        //nếu bàn trống thì tạo HD, ngược lại thì update món ăn trong CTHD
        if(banAnService.get_BanById(idBan).getTrangThai()==0){
            banAnService.update_status(idBan,1);
            HoaDonEntity hd=hoaDonService.create(0);
            banAnHoaDonService.create(ban,hd);
            chiTietHoaDonService.update(hd,sp);
        }
        else {
            HoaDonEntity hd=hoaDonService.get_HD_ByIdBan(idBan);
            chiTietHoaDonService.update(hd,sp);
        }
        Object[]infor={idBan,idSP};
        return infor;
    }

    @RequestMapping(value = "/order-detail/table={id}", method = RequestMethod.GET)
    public String order_detail(@PathVariable("id") Integer id, Model model){
        List<ChiTietHoaDonEntity>list=chiTietHoaDonService.get_CTHD(hoaDonService.get_HD_ByIdBan(id).getId());
        model.addAttribute("table",banAnService.get_BanById(id));
        model.addAttribute("listSP",list);
        model.addAttribute("hoaDon",hoaDonService.get_HD_ByIdBan(id));
        return "admin/pos/chiTietHoaDon";
    }

    @ResponseBody
    @RequestMapping(value = "/delete/table={idBan}&product={idSP}")
    public Object[] delete_order_detail(@PathVariable("idBan") Integer idBan,@PathVariable("idSP") Integer idSP){
        SanPhamEntity sp=sanPhamService.get_SanPhamById(idSP);
        HoaDonEntity hd=hoaDonService.get_HD_ByIdBan(idBan);
        int idCTHD=chiTietHoaDonService.find_CTHD_By_IdHD_IdSP(hd.getId(),sp.getId());
        chiTietHoaDonService.delete_CTHD(idCTHD);
        hoaDonService.update_Hd(hd.getId());

        Object[]infor={hoaDonService.get_HD_ByIdBan(idBan).getTongTien()};
        return infor;
    }

    @ResponseBody
    @RequestMapping(value = "/update/{idBan}/{idSP}/{qty}", method = RequestMethod.GET)
    public Object update_order_detail(@PathVariable("idBan") Integer idBan,@PathVariable("idSP") Integer idSP,@PathVariable("qty")Integer qty){
        SanPhamEntity sp=sanPhamService.get_SanPhamById(idSP);
        HoaDonEntity hd=hoaDonService.get_HD_ByIdBan(idBan);
        int idCTHD=chiTietHoaDonService.find_CTHD_By_IdHD_IdSP(hd.getId(),sp.getId());
        chiTietHoaDonService.update_qty(qty,idCTHD);
        chiTietHoaDonService.update(hd,sp);
        hoaDonService.update_Hd(hd.getId());

        Object[]info={hoaDonService.get_HD_ByIdBan(idBan).getTongTien()};
        return info;
    }

    @RequestMapping(value = "/payment/{idBan}/{idHD}",method = RequestMethod.GET)
    public String payment(@PathVariable("idHD")int idHD,@PathVariable("idBan")int idBan){
        hoaDonService.payment(idHD);
        banAnService.update_status(idBan,0);
        return "redirect:/admin/pos/table";
    }

    @RequestMapping(value = "/list-product/search", method = RequestMethod.POST)
    public String search_SP(@RequestParam("idBan")int idBan,@ModelAttribute("search") SearchDTO searchDTO, Model model){
        if(searchDTO.getString()==""){
            return "redirect:/admin/pos/list-product";
        }
        else {
            List<SanPhamEntity>listAll = sanPhamService.search(searchDTO.getString());
            model.addAttribute("listSP",listAll);
            model.addAttribute("search",new SearchDTO());
            model.addAttribute("table",banAnService.get_BanById(idBan));
            return "admin/pos/danhSachSanPhamPos";
        }
    }

    @RequestMapping(value = "/table/kv={id}", method = RequestMethod.GET)
    public String search_table(@PathVariable("id")Integer id, Model model){
        model.addAttribute("listBan",banAnService.get_Ban_By_IdKV(id));
        model.addAttribute("listKV",khuVucService.get_All_KV());
        model.addAttribute("search",new SearchDTO());
        return "admin/pos/pos";
    }

    @RequestMapping(value = "/listdbb", method = RequestMethod.GET)
    public String dondatban(Model model){
        model.addAttribute("list",donDatBanService.getListDaDuyet());
        model.addAttribute("search",new SearchDTO());
        List<BanAnEntity> a=banAnService.get_Ban_Trong();
        return "/admin/pos/danhSachDon";
    }
    @RequestMapping(value = "/listddb/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("search") SearchDTO searchDTO, Model model){
        if(searchDTO.getString()==""){
            return "redirect:/admin/pos/listdbb";
        }
        else {
            List<DonDatBanEntity>l=donDatBanService.getListSearch(searchDTO.getString());
            String a=searchDTO.getString();
            model.addAttribute("list",donDatBanService.getListSearch(searchDTO.getString()));
            model.addAttribute("search",new SearchDTO());
            return "admin/pos/danhSachDon";
        }
    }

    @RequestMapping(value = "/listddb/chonban/{idHd}", method = RequestMethod.GET)
    public String chonban(@PathVariable("idHd")Integer idHd, Model model){
        model.addAttribute("idHd",idHd);
        model.addAttribute("mode",1);
        model.addAttribute("listBan",banAnService.get_Ban_Trong());
        model.addAttribute("listKV",khuVucService.get_All_KV());
        model.addAttribute("search",new SearchDTO());
        return "admin/pos/pos";
    }
    @RequestMapping(value = "/chon/{idHd}/{idBan}", method = RequestMethod.GET)
    public String chon(@PathVariable("idHd")Integer idHd,@PathVariable("idBan")Integer idBan, Model model){
        HoaDonEntity hd =hoaDonService.get_byId(idHd);
        BanAnEntity ban=banAnService.get_BanById(idBan);
        banAnHoaDonService.create(ban,hd);
        banAnService.update_status(idBan,1);
        donDatBanService.update_mode(idHd,2);
        return "redirect:/admin/pos/listdbb";
    }
}
