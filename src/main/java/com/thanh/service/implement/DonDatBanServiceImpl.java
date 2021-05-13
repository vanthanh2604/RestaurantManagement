package com.thanh.service.implement;

import com.thanh.dto.DonDatBanDTO;
import com.thanh.entity.BanAnHoaDonEntity;
import com.thanh.entity.DonDatBanEntity;
import com.thanh.entity.HoaDonEntity;
import com.thanh.repository.DonDatBanRepository;
import com.thanh.repository.HoaDonRepository;
import com.thanh.repository.KhachHangRepository;
import com.thanh.service.interf.DonDatBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class DonDatBanServiceImpl implements DonDatBanService {
    @Autowired
    private DonDatBanRepository donDatBanRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    HttpSession session;
    @Override
    public void create(DonDatBanDTO donDatBanDTO) {
        DonDatBanEntity db= new DonDatBanEntity();
        db.setIdHD(donDatBanDTO.getIdHD());
        db.setTenKH(donDatBanDTO.getTenKH());
        db.setEmail(donDatBanDTO.getEmail());
        db.setGhiChu(donDatBanDTO.getGhiChu());
        db.setSoNguoi(Integer.parseInt(donDatBanDTO.getSoNguoi()));
        db.setSdt(donDatBanDTO.getSdt());
        db.setNgayTao(new Date());
        db.setKhachHang(khachHangRepository.findById(((int) session.getAttribute("idUser"))).get());
        String s=donDatBanDTO.getNgayDatBan();
        String s1="";
        String s2="";
        String[] c=new String[2];
        int[] ngay=new int[3];
        int[] gio=new int[2];
        int i=0,j=0,k=0;
        for (String w:s.split(",")
        ) {
            c[i]=w;
            ++i;
        }
        s1=c[0];s2=c[1];
        for (String w:s1.split("-")
        ) {
            ngay[j]=Integer.parseInt(w);
            ++j;
        }
        for (String w:s2.split(":")
        ) {
            gio[k]=Integer.parseInt(w);
            ++k;
        }
        Date date = new GregorianCalendar(ngay[0],ngay[1]-1,ngay[2],gio[0],gio[1],0).getTime();
        db.setNgayDatBan(date);
        donDatBanRepository.save(db);
    }

    @Override
    public List<DonDatBanEntity> get_All() {
        return (List<DonDatBanEntity>) donDatBanRepository.findAll();
    }

    @Override
    public void delete(int id) {
        donDatBanRepository.deleteById(id);
    }

    @Override
    public void update_status(int id, int idHd) {
        DonDatBanEntity ddb=donDatBanRepository.findById(id).get();
        ddb.setTrangThai(1);
        donDatBanRepository.save(ddb);

        HoaDonEntity hd=hoaDonRepository.findById(idHd).get();
        hd.setTrangThai(4);
        hoaDonRepository.save(hd);
    }

    @Override
    public List<DonDatBanEntity> getListChuaDuyet() {
        return donDatBanRepository.findChuaDuyet();
    }
    @Override
    public List<DonDatBanEntity> getListDaDuyet() {
        return donDatBanRepository.findDaDuyet();
    }

    @Override
    public List<DonDatBanEntity> getListSearch(String s) {
        return donDatBanRepository.searchList(s);
    }

    @Override
    public void update_mode(int id, int mode) {
        DonDatBanEntity don=donDatBanRepository.findByIdHd(id);
        don.setTrangThai(mode);
        donDatBanRepository.save(don);
    }

    @Override
    public DonDatBanEntity get_by_Id(int id) {
        return donDatBanRepository.findById(id).get();
    }
}
