package com.thanh.service.implement;

import com.thanh.repository.ChiTietPhieuNhapRepository;
import com.thanh.service.interf.ChiTietPhieuNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietPhieuNhapServiceImpl implements ChiTietPhieuNhapService {
    @Autowired
    private ChiTietPhieuNhapRepository chiTietPhieuNhapRepository;
}
