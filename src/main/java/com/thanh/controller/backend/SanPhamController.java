package com.thanh.controller.backend;

import com.thanh.dto.SearchDTO;
import com.thanh.entity.SanPhamEntity;
import com.thanh.entity.TheLoaiEntity;
import com.thanh.dto.SanPhamDTO;
import com.thanh.service.interf.SanPhamService;
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
@RequestMapping("/admin/sanpham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private TheLoaiService theLoaiService;
    @Autowired
    HttpSession session;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        if(session.getAttribute("username")!=null) {
            List<SanPhamEntity>listAll = sanPhamService.get_All_SP();
            List<SanPhamEntity>listSP = sanPhamService.get_limit(listAll,1,5);
            List<String>listTL= theLoaiService.get_All_The_Loai_name();
            model.addAttribute("listTL",listTL);
            model.addAttribute("listSP",listSP);
            model.addAttribute("SanPham",new SanPhamDTO());
            model.addAttribute("search",new SearchDTO());
            model.addAttribute("tht",1);
            double tongsopage= Math.ceil((double)listAll.size()/5);
            model.addAttribute("tongsotrang",tongsopage);
            return "admin/danhSachSanPham";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "/list/page={i}", method = RequestMethod.GET)
    public String listlimit(@PathVariable("i") int i,Model model){
        List<SanPhamEntity>listAll = sanPhamService.get_All_SP();
        List<SanPhamEntity>listSP = sanPhamService.get_limit(listAll,i,5);
        List<String>listTL= theLoaiService.get_All_The_Loai_name();
        model.addAttribute("listTL",listTL);
        model.addAttribute("listSP",listSP);
        model.addAttribute("SanPham",new SanPhamDTO());
        model.addAttribute("search",new SearchDTO());
        model.addAttribute("tht",i);
        double tongsopage= Math.ceil((double)listAll.size()/5);
        model.addAttribute("tongsotrang",tongsopage);
        return "admin/danhSachSanPham";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String add_SP(@ModelAttribute("SanPham") SanPhamDTO sp){
        SanPhamEntity sanPhamEntity=new SanPhamEntity();
        sanPhamEntity.setTenSP(sp.getTenSP());
        sanPhamEntity.setGiaTien(sp.getGiaTien());
        sanPhamEntity.setMoTa(sp.getMoTa());
        sanPhamEntity.setSoLuong(sp.getSoLuong());
        sanPhamEntity.setHinhAnh(sp.getHinhAnh());
        sanPhamEntity.setTheLoaiEntity(theLoaiService.get_TL_ByName(sp.getTenTL()));
        sanPhamService.addSanPham(sanPhamEntity);
        return "redirect:/admin/sanpham/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete_SP(@PathVariable("id") int id){
        sanPhamService.deleteSanPham(id);
        return "redirect:/admin/sanpham/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit_SP(@PathVariable int id, Model model){
        model.addAttribute("SanPham",new SanPhamDTO());
        List<String>listTL= theLoaiService.get_All_The_Loai_name();
        model.addAttribute("listTL",listTL);
        SanPhamEntity sanPhamEntity=sanPhamService.get_SanPhamById(id);
        SanPhamDTO sanPhamDTO =new SanPhamDTO();

        sanPhamDTO.setId(sanPhamEntity.getId());
        sanPhamDTO.setTenSP(sanPhamEntity.getTenSP());
        sanPhamDTO.setGiaTien(sanPhamEntity.getGiaTien());
        sanPhamDTO.setMoTa(sanPhamEntity.getMoTa());
        sanPhamDTO.setSoLuong(sanPhamEntity.getSoLuong());
        sanPhamDTO.setTenTL(sanPhamEntity.getTheLoaiEntity().getTenTheLoai());
        sanPhamDTO.setTrangThai(sanPhamEntity.getTrangThai());
        sanPhamDTO.setHinhAnh(sanPhamEntity.getHinhAnh());
        sanPhamDTO.setHinhAnhTam(sanPhamEntity.getHinhAnh());

        model.addAttribute("SanPham", sanPhamDTO);
        return "admin/editSanPham";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update_SP(@ModelAttribute("SanPham") SanPhamDTO sanPhamDTO){
        TheLoaiEntity theLoaiEntity= theLoaiService.get_TL_ByName(sanPhamDTO.getTenTL());
        sanPhamService.updateSanPham(sanPhamDTO,theLoaiEntity);
        return "redirect:/admin/sanpham/list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search_SP(@ModelAttribute("search") SearchDTO searchDTO,Model model){
        if(searchDTO.getString()==""){
            return "redirect:/admin/sanpham/list";
        }
        else {
            model.addAttribute("search",new SearchDTO());
            List<SanPhamEntity>listAll = sanPhamService.search(searchDTO.getString());
            List<String>listTL= theLoaiService.get_All_The_Loai_name();
            model.addAttribute("listTL",listTL);
            model.addAttribute("listSP",listAll);
            model.addAttribute("SanPham",new SanPhamDTO());
            return "admin/danhSachSanPham";
        }
    }

}
