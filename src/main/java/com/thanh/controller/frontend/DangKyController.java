package com.thanh.controller.frontend;

import com.thanh.entity.KhachHangEntity;
import com.thanh.service.interf.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DangKyController {
    @Autowired
    KhachHangService khachHangService;
    @RequestMapping(value = "/dangky", method = RequestMethod.GET)
    public String dangky(){
        return "user/dangky";
    }

    @RequestMapping(value = "/checkregist", method = RequestMethod.POST)
    public String result(@RequestParam("email") String email,@RequestParam("ten") String ten,
                         @RequestParam("password") String password,@RequestParam("password2") String password2,
                         ModelMap modelMap){
        if (khachHangService.getKHByEmail(email)!=null && password!=password2) {
            modelMap.put("alert", "Đăng ký thất bại");
            return "user/dangky";
        } else {
            khachHangService.create(email,ten,password);
            modelMap.put("alert", "Đăng ký thành công!");
            return "user/dangky";
        }
    }

}
