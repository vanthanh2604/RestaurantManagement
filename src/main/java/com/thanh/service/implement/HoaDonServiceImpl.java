package com.thanh.service.implement;

import com.thanh.dto.HoaDonDTO;
import com.thanh.dto.SearchReportDTO;
import com.thanh.entity.ChiTietHoaDonEntity;
import com.thanh.entity.HoaDonEntity;
import com.thanh.entity.KhachHangEntity;
import com.thanh.entity.SanPhamEntity;
import com.thanh.repository.ChiTietHoaDonRepository;
import com.thanh.repository.HoaDonRepository;
import com.thanh.service.interf.ChiTietHoaDonService;
import com.thanh.service.interf.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;
    @Override
    public List<HoaDonEntity> get_All() {
        return (List<HoaDonEntity>) hoaDonRepository.findAll();
    }

    @Override
    public HoaDonEntity create(int mode) {
        HoaDonEntity hd=new HoaDonEntity();
        hd.setNgayTao();
        hd.setTrangThai(mode);
        hoaDonRepository.save(hd);
        return hoaDonRepository.getHoaDon();
    }
    @Override
    public HoaDonEntity create(KhachHangEntity kh, int mode) {
        HoaDonEntity hd=new HoaDonEntity();
        hd.setNgayTao();
        hd.setKhachHangEntity(kh);
        hd.setTrangThai(mode);
        hoaDonRepository.save(hd);
        return hoaDonRepository.getHoaDon();
    }

    @Override
    public void deleteById(int id) {
        hoaDonRepository.deleteById(id);
    }

    @Override
    public HoaDonEntity get_HD_ByIdBan(int id) {
        return hoaDonRepository.getHoaDonByIdBan(id);
    }

    @Override
    public void update_Hd(int id) {
        double tong=0;
        HoaDonEntity hd=hoaDonRepository.findById(id).get();
        List<ChiTietHoaDonEntity>list=chiTietHoaDonRepository.get_CTHD_By_IdHD(id);
        for (ChiTietHoaDonEntity item:list
        ) {
            tong=tong+item.getThanhTien();
        }
        hd.setTongTien(tong);
        hoaDonRepository.save(hd);
    }

    @Override
    public void payment(int idHD) {
        HoaDonEntity hd=hoaDonRepository.findById(idHD).get();
        if(hd.getTrangThai()==0){
            hd.setTrangThai(1);
        }
        if(hd.getTrangThai()==4){
            hd.setTrangThai(5);
        }
        hoaDonRepository.save(hd);
    }

    @Override
    public HoaDonEntity get_byId(int id) {
        return hoaDonRepository.findById(id).get();
    }

    @Override
    public int get_total_invoice() {
        return hoaDonRepository.total_invoice();
    }

    @Override
    public Double total_revenue(List<HoaDonEntity> hds) {
        double tong=0;
        for (HoaDonEntity item:hds
             ) {
            tong+=item.getTongTien();
        }
        return tong;
    }

    @Override
    public List<HoaDonEntity> get_hd_ngay(SearchReportDTO reportDTO) {
        return hoaDonRepository.findByDate(reportDTO.getFrom(),reportDTO.getTo());
    }

}
