package com.thanh.service.interf;
import com.thanh.dto.HoaDonDTO;
import com.thanh.dto.SearchReportDTO;
import com.thanh.entity.ChiTietHoaDonEntity;
import com.thanh.entity.HoaDonEntity;
import com.thanh.entity.KhachHangEntity;
import com.thanh.entity.SanPhamEntity;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface HoaDonService {
    List<HoaDonEntity>get_All();
    HoaDonEntity create(int mode);
    HoaDonEntity create(KhachHangEntity Kh, int mode);
    void deleteById(int id);
    HoaDonEntity get_HD_ByIdBan(int id);
    void update_Hd(int id);
    void payment(int idHD);
    HoaDonEntity get_byId(int id);
    int get_total_invoice();
    Double total_revenue(List<HoaDonEntity> list);
    List<HoaDonEntity>get_hd_ngay(SearchReportDTO reportDTO);
}
