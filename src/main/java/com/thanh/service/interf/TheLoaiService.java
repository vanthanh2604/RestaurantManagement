package com.thanh.service.interf;
import com.thanh.entity.TheLoaiEntity;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface TheLoaiService {
    List<TheLoaiEntity> get_All_TL();
    List<String>get_All_The_Loai_name();
    TheLoaiEntity get_TL_ByName(String name);
    void add_DanhMuc(TheLoaiEntity theLoaiEntity);
    void delete_DanhMuc(int id);
    void update_DanhMuc(TheLoaiEntity theLoaiEntity);
    TheLoaiEntity get_TL_ById(int id);
    List<TheLoaiEntity>get_limit(List<TheLoaiEntity> list, int hienTai, int soPTu);
}
