package com.thanh.service.interf;
import com.thanh.entity.SanPhamEntity;
import com.thanh.entity.TheLoaiEntity;
import com.thanh.dto.SanPhamDTO;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface SanPhamService {
    List<SanPhamEntity> get_All_SP();
    List<SanPhamEntity> get_All();
    void addSanPham(SanPhamEntity sanPhamEntity);
    void deleteSanPham(Integer id);
    SanPhamEntity get_SanPhamById(Integer id);
    void updateSanPham(SanPhamDTO sanPhamDTO, TheLoaiEntity theLoaiEntity);
    List<SanPhamEntity>get_limit(List<SanPhamEntity> list,int hienTai,int soPTu);
    List<SanPhamEntity>search(String string);
    List<SanPhamEntity>get_SPTL(int id);
}
