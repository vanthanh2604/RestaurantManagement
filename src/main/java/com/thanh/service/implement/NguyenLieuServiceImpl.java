package com.thanh.service.implement;

import com.thanh.repository.NguyenLieuRepository;
import com.thanh.service.interf.NguyenLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NguyenLieuServiceImpl implements NguyenLieuService {
    @Autowired
    private NguyenLieuRepository nguyenLieuRepository;
}
