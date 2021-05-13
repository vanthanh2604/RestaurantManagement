package com.thanh.service.implement;

import com.thanh.dto.LienHeDTO;
import com.thanh.entity.LienHeEntity;
import com.thanh.repository.LienHeRepository;
import com.thanh.service.interf.LienHeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LienHeServiceImpl implements LienHeService {
    @Autowired
    private LienHeRepository lienHeRepository;

    @Override
    public void create(LienHeDTO lienHeDTO) {
        LienHeEntity lh=new LienHeEntity();
        lh.setEmail(lienHeDTO.getEmailLH());
        lh.setTen(lienHeDTO.getHoTen());
        lh.setNgayTao();
        lh.setSdt(lienHeDTO.getSdtLH());
        lh.setNoiDung(lienHeDTO.getNoiDung());
        lienHeRepository.save(lh);
    }

    @Override
    public List<LienHeEntity> get_All() {
        return (List<LienHeEntity>) lienHeRepository.findAll();
    }

    @Override
    public void delete(int id) {
        lienHeRepository.deleteById(id);
    }
}
