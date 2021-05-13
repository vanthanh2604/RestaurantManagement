package com.thanh.service.implement;

import com.thanh.entity.TheLoaiEntity;
import com.thanh.repository.TheLoaiRepository;
import com.thanh.service.interf.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheLoaiServiceImpl implements TheLoaiService {
    @Autowired
    private TheLoaiRepository theLoaiRepository;

    @Override
    public List<String> get_All_The_Loai_name() {
        List<String> nameTL=new ArrayList<>();
        List<TheLoaiEntity>tls= (List<TheLoaiEntity>) theLoaiRepository.findAll();
        for (TheLoaiEntity tl: tls) {
            String name = tl.getTenTheLoai();
            nameTL.add(name);
        }
        return nameTL;
    }

    @Override
    public TheLoaiEntity get_TL_ByName(String name) {
        TheLoaiEntity theLoaiEntity=new TheLoaiEntity();
        List<TheLoaiEntity>list= (List<TheLoaiEntity>) theLoaiRepository.findAll();
        for (TheLoaiEntity tl: list) {
            if (tl.getTenTheLoai().equals(name)){
                theLoaiEntity=tl;
            }
        }
        return theLoaiEntity;
    }

    @Override
    public List<TheLoaiEntity> get_All_TL() {
        return (List<TheLoaiEntity>) theLoaiRepository.findAll();
    }

    @Override
    public void add_DanhMuc(TheLoaiEntity theLoaiEntity) {
        theLoaiRepository.save(theLoaiEntity);
    }

    @Override
    public void delete_DanhMuc(int id) {
        theLoaiRepository.deleteById(id);
    }

    @Override
    public void update_DanhMuc(TheLoaiEntity theLoaiEntity) {
        TheLoaiEntity tl=theLoaiRepository.findById(theLoaiEntity.getId()).get();
        tl.setTenTheLoai(theLoaiEntity.getTenTheLoai());
        tl.setMoTa(theLoaiEntity.getMoTa());
        theLoaiRepository.save(tl);
    }

    @Override
    public TheLoaiEntity get_TL_ById(int id) {
        return theLoaiRepository.findById(id).get();
    }

    @Override
    public List<TheLoaiEntity> get_limit(List<TheLoaiEntity> list, int hienTai, int soPTu) {
        List<TheLoaiEntity>limit=new ArrayList<>();
        for (int i = (hienTai-1)*soPTu+1; i <= hienTai*soPTu; i++) {
            if(i>list.size()) {break;}
            limit.add(list.get(i-1));
        }
        return limit;
    }
}
