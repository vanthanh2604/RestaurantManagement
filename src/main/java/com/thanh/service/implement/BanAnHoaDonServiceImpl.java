package com.thanh.service.implement;

import com.thanh.entity.BanAnEntity;
import com.thanh.entity.BanAnHoaDonEntity;
import com.thanh.entity.HoaDonEntity;
import com.thanh.repository.BanAnHoaDonRepository;
import com.thanh.repository.HoaDonRepository;
import com.thanh.service.interf.BanAnHoaDonService;
import com.thanh.service.interf.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BanAnHoaDonServiceImpl implements BanAnHoaDonService {
    @Autowired
    private BanAnHoaDonRepository banAnHoaDonRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Override
    public void create(BanAnEntity banAnEntity, HoaDonEntity hoaDonEntity) {
        BanAnHoaDonEntity banAnHoaDonEntity=new BanAnHoaDonEntity();
        banAnHoaDonEntity.setBanAnEntity(banAnEntity);
        banAnHoaDonEntity.setHoaDonEntity(hoaDonEntity);
        banAnHoaDonRepository.save(banAnHoaDonEntity);
    }

}
