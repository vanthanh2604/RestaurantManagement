package com.thanh.service.implement;

import com.thanh.repository.PhieuNhapRepository;
import com.thanh.service.interf.PhieuNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhieuNhapServiceImpl implements PhieuNhapService {
    @Autowired
    private PhieuNhapRepository phieuNhapRepository;
}
