package com.thanh.service.implement;

import com.thanh.repository.CongThucRepository;
import com.thanh.service.interf.CongThucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CongThucServiceImpl implements CongThucService {
    @Autowired
    private CongThucRepository congThucRepository;
}
