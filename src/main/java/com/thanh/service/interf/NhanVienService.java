package com.thanh.service.interf;
import com.thanh.entity.NhanVienEntity;

import javax.transaction.Transactional;
@Transactional
public interface NhanVienService {
    NhanVienEntity getNV(String username,String pass);
}
