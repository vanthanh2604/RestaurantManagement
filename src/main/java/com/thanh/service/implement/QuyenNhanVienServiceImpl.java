package com.thanh.service.implement;

import com.thanh.repository.QuyenNhanVienRepository;
import com.thanh.service.interf.QuyenNhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuyenNhanVienServiceImpl implements QuyenNhanVienService {
    @Autowired
    private QuyenNhanVienRepository quyenNhanVienRepository;
}
