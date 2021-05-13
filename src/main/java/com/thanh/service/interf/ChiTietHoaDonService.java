package com.thanh.service.interf;
import com.thanh.dto.ChiTietHoaDonDTO;
import com.thanh.entity.ChiTietHoaDonEntity;
import com.thanh.entity.HoaDonEntity;
import com.thanh.entity.SanPhamEntity;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ChiTietHoaDonService {
    List<ChiTietHoaDonEntity>get_All();
    void update(HoaDonEntity hoaDonEntity,SanPhamEntity sanPhamEntity);
    ChiTietHoaDonEntity get_CTHD(int idHD,int idSP);
    List<ChiTietHoaDonEntity> get_CTHD(int idHD);
    int find_CTHD_By_IdHD_IdSP(int idHD,int idSP);
    void delete_CTHD(int idCTHD);
    void update_qty(int qty,int idCTHD);
    void create(List<ChiTietHoaDonEntity> cts);
    void delete_By_IdHd(int idHd);
}
