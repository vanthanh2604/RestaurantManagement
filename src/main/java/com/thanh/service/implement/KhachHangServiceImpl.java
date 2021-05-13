package com.thanh.service.implement;

import com.thanh.entity.KhachHangEntity;
import com.thanh.repository.KhachHangRepository;
import com.thanh.service.interf.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHangEntity> get_All_KH() {
        return (List<KhachHangEntity>) khachHangRepository.findAll();
    }

    @Override
    public void addKhachHang(KhachHangEntity khachHangEntity) {
        khachHangRepository.save(khachHangEntity);
    }

    @Override
    public void deleteKhachHang(int id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHangEntity get_KH_ById(int id) {
        return khachHangRepository.findById(id).get();
    }

    @Override
    public void update_KH(KhachHangEntity khachHangEntity) {
        KhachHangEntity kh=khachHangRepository.findById(khachHangEntity.getId()).get();
        kh.setTenKH(khachHangEntity.getTenKH());
        kh.setDiaChi(khachHangEntity.getDiaChi());
        kh.setEmail(khachHangEntity.getEmail());
        kh.setSdt(khachHangEntity.getSdt());
        khachHangRepository.save(kh);
    }

    @Override
    public KhachHangEntity kh(String email, String pass) {
        return khachHangRepository.findKH(email,pass);
    }

    @Override
    public void create(String email,String ten,String password) {
        KhachHangEntity kh=new KhachHangEntity();
        kh.setEmail(email);
        kh.setTenKH(ten);
        kh.setPassWord(password);
        khachHangRepository.save(kh);
    }

    @Override
    public KhachHangEntity getKHByEmail(String email) {
        return khachHangRepository.findKhByEmail(email);
    }
}
