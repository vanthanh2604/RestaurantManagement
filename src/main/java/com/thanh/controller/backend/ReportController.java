package com.thanh.controller.backend;

import com.thanh.dto.SearchReportDTO;
import com.thanh.entity.HoaDonEntity;
import com.thanh.service.interf.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/report")
public class ReportController {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    HttpSession session;
    @RequestMapping(value = "list")
    public String list(Model model){
        if(session.getAttribute("username")!=null) {
            List<HoaDonEntity>list=hoaDonService.get_All();
            model.addAttribute("list",list);
            model.addAttribute("search", new SearchReportDTO());
            model.addAttribute("total",hoaDonService.total_revenue(list));
            return "admin/baoCaoDanhThu";
        } else { return "admin/404"; }
    }

    @RequestMapping(value = "result")
    public String result(@ModelAttribute("search")SearchReportDTO reportDTO, Model model){
        List<HoaDonEntity>list=hoaDonService.get_hd_ngay(reportDTO);
        model.addAttribute("list",list);
        model.addAttribute("search", new SearchReportDTO());
        model.addAttribute("total",hoaDonService.total_revenue(list));
        return "admin/baoCaoDanhThu";
    }
}
