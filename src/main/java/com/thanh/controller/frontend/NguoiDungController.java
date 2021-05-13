package com.thanh.controller.frontend;

import com.thanh.dto.DonDatBanDTO;
import com.thanh.dto.LienHeDTO;
import com.thanh.dto.SanPhamDTO;
import com.thanh.dto.SearchDTO;
import com.thanh.entity.DonDatBanEntity;
import com.thanh.entity.SanPhamEntity;
import com.thanh.service.interf.DonDatBanService;
import com.thanh.service.interf.LienHeService;
import com.thanh.service.interf.SanPhamService;
import com.thanh.service.interf.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NguoiDungController {
    @Autowired
    private TheLoaiService theLoaiService;
    @Autowired
    private SanPhamService sanPhamService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView mav=new ModelAndView("/user/index");
        mav.addObject("menu",theLoaiService.get_All_TL());
        List<SanPhamEntity>list= sanPhamService.get_All();
        mav.addObject("listSP",list);
        return mav;
    }

    @RequestMapping(value = "/danhmuc={id}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable int id){
        ModelAndView mav=new ModelAndView("/user/index");
        mav.addObject("menu",theLoaiService.get_All_TL());
        List<SanPhamEntity>list= sanPhamService.get_SPTL(id);
        mav.addObject("listSP",list);
        mav.addObject("datban",new DonDatBanDTO());
        mav.addObject("lienhe",new LienHeDTO());
        return mav;
    }
}
