package com.thanh.service.interf;

import com.thanh.dto.DonDatBanDTO;
import com.thanh.dto.LienHeDTO;
import com.thanh.entity.DonDatBanEntity;
import com.thanh.entity.LienHeEntity;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface LienHeService {
    void create(LienHeDTO lienHeDTO);
    List<LienHeEntity> get_All();
    void delete(int id);
}
