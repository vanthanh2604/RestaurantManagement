package com.thanh.service.implement;

import com.thanh.dto.BanDTO;
import com.thanh.entity.BanAnEntity;
import com.thanh.entity.KhuVucEntity;
import com.thanh.repository.BanAnRepository;
import com.thanh.service.interf.BanAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BanAnServiceImpl implements BanAnService {
    @Autowired
    private BanAnRepository banAnRepository;

    @Override
    public List<BanAnEntity> get_All_Ban() {
        return (List<BanAnEntity>) banAnRepository.findAll();
    }

    @Override
    public void add_Ban(BanAnEntity banAnEntity) {
        banAnRepository.save(banAnEntity);
    }

    @Override
    public void delete_Ban(Integer id) {
        banAnRepository.deleteById(id);
    }

    @Override
    public BanAnEntity get_BanById(Integer id) {
        return banAnRepository.findById(id).get();
    }

    @Override
    public void update_Ban(BanDTO banDTO, KhuVucEntity khuVucEntity) {
        BanAnEntity ban=banAnRepository.findById(banDTO.getId()).get();
        ban.setTenBanAn(banDTO.getTenBanAn());
        ban.setTrangThai(banDTO.getTrangThai());
        ban.setKhuVucEntity(khuVucEntity);
        banAnRepository.save(ban);
    }

    @Override
    public List<BanAnEntity> get_limit(List<BanAnEntity> list, int hienTai, int soPTu) {
        List<BanAnEntity>limit=new ArrayList<>();
        for (int i = (hienTai-1)*soPTu+1; i <= hienTai*soPTu; i++) {
            if(i>list.size()) {break;}
            limit.add(list.get(i-1));
        }
        return limit;
    }

    @Override
    public List<BanAnEntity> search(String string) {
        return banAnRepository.getBanAnEntitiesByName(string);
    }

    @Override
    public void update_status(int idBan, int status) {
        if(status==1){
            BanAnEntity b=banAnRepository.findById(idBan).get();
            b.setTrangThai(1);
            banAnRepository.save(b);
        }
        else {
            BanAnEntity b=banAnRepository.findById(idBan).get();
            b.setTrangThai(0);
            banAnRepository.save(b);
        }
    }

    @Override
    public int get_total_table() {
        return banAnRepository.total_table();
    }

    @Override
    public List<BanAnEntity> get_Ban_By_IdKV(int id) {
        return banAnRepository.get_Ban_ByIdKV(id);
    }

    @Override
    public List<BanAnEntity> get_Ban_Trong() {
        return banAnRepository.findBanTrong();
    }

}
