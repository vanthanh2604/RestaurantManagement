package com.thanh.controller.frontend;

import com.thanh.dto.DonDatBanDTO;
import com.thanh.service.implement.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GioHangController {
    @Autowired
    CartService cart;
    @RequestMapping(value = "/giohang", method = RequestMethod.GET)
    public String giohang(Model model){
        model.addAttribute("dondatban",new DonDatBanDTO());
        return "user/gioHang";
    }
    @ResponseBody
    @RequestMapping(value = "/giohang/add/{id}", method = RequestMethod.GET)
    public String add(@PathVariable("id") Integer id,Model model){
        cart.add(id);
        return "thanhcong";
    }
    @ResponseBody
    @RequestMapping(value = "/giohang/update/{id}/{qty}", method = RequestMethod.GET)
    public Object add(@PathVariable("id") Integer id,@PathVariable("qty") Integer qty){
        cart.update(id,qty);
        Object[] info={cart.getAmount()};
        return info;
    }

    @ResponseBody
    @RequestMapping(value = "/giohang/remove/{id}", method = RequestMethod.GET)
    public String removesp(@PathVariable("id") Integer id){
        cart.remove(id);
        return "thanhcong";
    }

    @ResponseBody
    @RequestMapping(value = "/giohang/clear", method = RequestMethod.GET)
    public String clear(){
        cart.clear();
        return "thanhcong";
    }
}
