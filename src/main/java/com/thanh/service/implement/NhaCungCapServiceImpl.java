package com.thanh.service.implement;

import com.thanh.entity.NhaCungCapEntity;
import com.thanh.repository.NhaCungCapRepository;
import com.thanh.service.interf.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;

    @Override
    public List<NhaCungCapEntity> get_All_NCC() {
        return (List<NhaCungCapEntity>) nhaCungCapRepository.findAll();
    }

    @Override
    public void add_NCC(NhaCungCapEntity nhaCungCapEntity) {
        nhaCungCapRepository.save(nhaCungCapEntity);
    }

    @Override
    public void delete_NCC(int id) {
        nhaCungCapRepository.deleteById(id);
    }

    @Override
    public void update_NCC(NhaCungCapEntity nhaCungCapEntity) {
        NhaCungCapEntity ncc=nhaCungCapRepository.findById(nhaCungCapEntity.getId()).get();
        ncc.setDiaChi(nhaCungCapEntity.getDiaChi());
        ncc.setEmail(nhaCungCapEntity.getEmail());
        ncc.setSdt(nhaCungCapEntity.getSdt());
        ncc.setTenNCC(nhaCungCapEntity.getTenNCC());
        nhaCungCapRepository.save(ncc);
    }

    @Override
    public NhaCungCapEntity get_NCC_ByID(int id) {
        return nhaCungCapRepository.findById(id).get();
    }
}
