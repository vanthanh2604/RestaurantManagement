package com.thanh.app;

import com.thanh.dto.DonDatBanDTO;
import com.thanh.dto.SearchReportDTO;
import com.thanh.entity.*;
import com.thanh.service.implement.*;
import com.thanh.service.interf.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanConfig.xml");
        HoaDonService sanPhamService = context.getBean(HoaDonServiceImpl.class);
//        ChiTietHoaDonService chiTietHoaDonService = context.getBean(ChiTietHoaDonServiceImpl.class);
//        BanAnService banAnService = context.getBean(BanAnServiceImpl.class);


        //set ngày tháng năm vào kh và định dạng lại thời gian
//        KhachHangEntity kh=new KhachHangEntity();
//        Date date = new GregorianCalendar(2014, 2, 11).getTime();
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        String dateString  = df.format(date);
//        System.out.println(dateString);
//        String s="02/04/2019";
//        int[] c=new int[3];
//        int i=0;
//        for (String w:s.split("/",0)
//             ) {
//            c[i]=Integer.parseInt(w);
//            ++i;
//        }
//        for (int a:c
//             ) {
//            System.out.println(a);
//        }
//        Date date = new GregorianCalendar(2020,1-1,6).getTime();
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        String dateString  = df.format(date);
//        System.out.println(dateString);

//        List<SanPhamEntity> sp=sanPhamService.get_SPTL(1);
//        for (SanPhamEntity item:sp
//             ) {
//            System.out.println(item.getId());
////        }
//        int ban=sanPhamService.create();
//
//            System.out.println(ban);
//        sanPhamService.update_status(1,0);
//        System.out.println(sanPhamService.get_BanById(1).getTrangThai());
//        int id=sanPhamService.get_HD_ByIdBan(1).getId();
//        System.out.println(id);
//        System.out.println(chiTietHoaDonService.get_CTHD(id));
//        chiTietHoaDonService.delete_CTHD_By_IdHD_IdSP(19,1);
//        int id=chiTietHoaDonService.find_CTHD_By_IdHD_IdSP(19,1);
//        System.out.println(id);
//        chiTietHoaDonService.delete_CTHD(id);
//        System.out.println(banAnService.get_total_table());

//        String a="'"+"2021/20/11"+"'";
//        System.out.println(a);
//        SearchReportDTO a=new SearchReportDTO();
//        a.setFrom("2021/01/9");
//        a.setTo("2021/01/12");
//        List<HoaDonEntity>h=sanPhamService.get_hd_ngay(a);
//        for (HoaDonEntity item:h
//             ) {
//            System.out.println(item.getId());
//        }

//        String a= "23:15:00";
//        int[] c=new int[3];
//        String c1="";
//        String c2="";
//        int i=0;
//        for (String w:a.split(":",0)
//        ) {
//            c[i]=Integer.parseInt(w);
//            ++i;
//        }
//        System.out.println("gio"+c[0]);
//        for (int item:c
//             ) {
//            System.out.println(item);
//        }

//        Date date = new GregorianCalendar(2020,1-1,6,23,15).getTime();
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        String dateString  = df.format(date);
//        System.out.println(dateString);
    }
}
