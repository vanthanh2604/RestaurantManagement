package com.thanh.service.implement;

import com.thanh.entity.NhanVienEntity;
import com.thanh.repository.NhanVienRepository;
import com.thanh.service.interf.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public NhanVienEntity getNV(String username, String pass) {
        return nhanVienRepository.findNv(username, pass);
    }
}
