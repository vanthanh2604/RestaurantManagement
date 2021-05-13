package com.thanh.service.implement;

import com.thanh.repository.QuyenRepository;
import com.thanh.service.interf.QuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuyenServiceImpl implements QuyenService {
    @Autowired
    private QuyenRepository quyenRepository;
}
