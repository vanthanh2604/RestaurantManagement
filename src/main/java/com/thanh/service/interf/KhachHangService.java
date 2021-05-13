package com.thanh.service.interf;
import com.thanh.entity.KhachHangEntity;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface KhachHangService {
    List<KhachHangEntity>get_All_KH();
    void addKhachHang(KhachHangEntity khachHangEntity);
    void deleteKhachHang(int id);
    KhachHangEntity get_KH_ById(int id);
    void update_KH(KhachHangEntity khachHangEntity);
    KhachHangEntity kh(String email,String pass);
    void create(String email,String ten,String password);
    KhachHangEntity getKHByEmail(String email);
}
