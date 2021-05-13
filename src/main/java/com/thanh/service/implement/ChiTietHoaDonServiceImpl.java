package com.thanh.service.implement;

import com.thanh.dto.ChiTietHoaDonDTO;
import com.thanh.entity.BanAnEntity;
import com.thanh.entity.ChiTietHoaDonEntity;
import com.thanh.entity.HoaDonEntity;
import com.thanh.entity.SanPhamEntity;
import com.thanh.repository.ChiTietHoaDonRepository;
import com.thanh.repository.HoaDonRepository;
import com.thanh.service.interf.ChiTietHoaDonService;
import com.thanh.service.interf.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {
    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Override
    public List<ChiTietHoaDonEntity> get_All() {
        return (List<ChiTietHoaDonEntity>) chiTietHoaDonRepository.findAll();
    }

    @Override
    public void update(HoaDonEntity hd,SanPhamEntity sp) {
        ChiTietHoaDonEntity cthd=chiTietHoaDonRepository.get_CTHD_By_IdHD_IdSP(hd.getId(),sp.getId());
        List<ChiTietHoaDonEntity>list=null;
        double tong=0;
        //nếu sp đã có trong cthd theo mã hóa đơn thì update số lượng, ngược lại thì thêm sp theo mã hóa đơn
        if(cthd!=null){
            cthd.setSoLuong(cthd.getSoLuong()+1);
            cthd.setThanhTien();
            chiTietHoaDonRepository.save(cthd);
        }
        else {
            ChiTietHoaDonEntity ctdh=new ChiTietHoaDonEntity();
            ctdh.setHoaDonEntity(hd);
            ctdh.setSanPhamEntity(sp);
            ctdh.setSoLuong(1);
            ctdh.setThanhTien();
            chiTietHoaDonRepository.save(ctdh);
        }
        list=chiTietHoaDonRepository.get_CTHD_By_IdHD(hd.getId());
        for (ChiTietHoaDonEntity item:list
        ) {
            tong=tong+item.getThanhTien();
        }
        hd.setTongTien(tong);
        hoaDonRepository.save(hd);
    }

    @Override
    public ChiTietHoaDonEntity get_CTHD(int idHD, int idSP) {
        return chiTietHoaDonRepository.get_CTHD_By_IdHD_IdSP(idHD,idSP);
    }

    @Override
    public List<ChiTietHoaDonEntity> get_CTHD(int idHD) {
        return (List<ChiTietHoaDonEntity>) chiTietHoaDonRepository.get_CTHD_By_IdHD(idHD);
    }

    @Override
    public int find_CTHD_By_IdHD_IdSP(int idHD, int idSP) {
        return chiTietHoaDonRepository.getId_CTHD_By_IdHD_IdSP(idHD,idSP);
    }

    @Override
    public void delete_CTHD(int idCTHD) {
        chiTietHoaDonRepository.deleteById(idCTHD);
    }

    @Override
    public void update_qty(int qty, int idCTHD) {
        ChiTietHoaDonEntity cthd=chiTietHoaDonRepository.findById(idCTHD).get();
        cthd.setSoLuong(qty-1);
        chiTietHoaDonRepository.save(cthd);
    }

    @Override
    public void create(List<ChiTietHoaDonEntity> cts) {
        for (ChiTietHoaDonEntity ct:cts
             ) {
            chiTietHoaDonRepository.save(ct);
        }
    }

    @Override
    public void delete_By_IdHd(int idHd) {
        chiTietHoaDonRepository.deleteByIdHd(idHd);
    }
}
