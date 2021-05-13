package com.thanh.service.implement;

import com.thanh.entity.SanPhamEntity;
import com.thanh.entity.TheLoaiEntity;
import com.thanh.dto.SanPhamDTO;
import com.thanh.repository.SanPhamRepository;
import com.thanh.service.interf.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPhamEntity> get_All_SP() {
        return sanPhamRepository.findAllDesc();
    }

    @Override
    public List<SanPhamEntity> get_All() {
        return (List<SanPhamEntity>) sanPhamRepository.findAll();
    }

    @Override
    public void addSanPham(SanPhamEntity sanPhamEntity) {
        sanPhamRepository.save(sanPhamEntity);
    }

    @Override
    public void deleteSanPham(Integer id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPhamEntity get_SanPhamById(Integer id) {
        return sanPhamRepository.findById(id).get();
    }

    @Override
    public void updateSanPham(SanPhamDTO sanPhamDTO, TheLoaiEntity theLoaiEntity) {
        SanPhamEntity sanPhamEntity= sanPhamRepository.findById(sanPhamDTO.getId()).get();
        sanPhamEntity.setSoLuong(sanPhamDTO.getSoLuong());
        sanPhamEntity.setMoTa(sanPhamDTO.getMoTa());
        sanPhamEntity.setGiaTien(sanPhamDTO.getGiaTien());
        sanPhamEntity.setTenSP(sanPhamDTO.getTenSP());
        sanPhamEntity.setTrangThai(sanPhamDTO.getTrangThai());
        sanPhamEntity.setTheLoaiEntity(theLoaiEntity);

        if(sanPhamDTO.getHinhAnh()=="")
        {
            sanPhamEntity.setHinhAnh(sanPhamDTO.getHinhAnhTam());
        }
        else{
            sanPhamEntity.setHinhAnh(sanPhamDTO.getHinhAnh());
        }
        sanPhamRepository.save(sanPhamEntity);
    }

    @Override
    public List<SanPhamEntity> get_limit(List<SanPhamEntity>list,int hienTai,int soPTu) {
        List<SanPhamEntity>limit=new ArrayList<>();
        for (int i = (hienTai-1)*soPTu+1; i <= hienTai*soPTu; i++) {
            if(i>list.size()) {break;}
            limit.add(list.get(i-1));
        }
        return limit;
    }

    @Override
    public List<SanPhamEntity> search(String string) {
        return sanPhamRepository.getSanPhamEntitiesByName(string);
    }

    @Override
    public List<SanPhamEntity> get_SPTL(int id) {
        return sanPhamRepository.getSPTL(id);
    }

}
