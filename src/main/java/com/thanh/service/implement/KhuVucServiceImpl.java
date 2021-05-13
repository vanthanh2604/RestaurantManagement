package com.thanh.service.implement;

import com.thanh.entity.KhuVucEntity;
import com.thanh.repository.KhuVucRepository;
import com.thanh.service.interf.KhuVucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhuVucServiceImpl implements KhuVucService {
    @Autowired
    private KhuVucRepository khuVucRepository;

    @Override
    public List<KhuVucEntity> get_All_KV() {
        return (List<KhuVucEntity>) khuVucRepository.findAll();
    }

    @Override
    public KhuVucEntity get_KV_ById(int id) {
        return khuVucRepository.findById(id).get();
    }

    @Override
    public void add_KhuVuc(KhuVucEntity khuVucEntity) {
        khuVucRepository.save(khuVucEntity);
    }

    @Override
    public void delete_KhuVuc(int id) {
        khuVucRepository.deleteById(id);
    }

    @Override
    public void update_KhuVuc(KhuVucEntity khuVucEntity) {
        KhuVucEntity kv=khuVucRepository.findById(khuVucEntity.getId()).get();
        kv.setTenKV(khuVucEntity.getTenKV());
        kv.setTrangThai(khuVucEntity.getTrangThai());
        khuVucRepository.save(kv);
    }

    @Override
    public List<String> get_All_KV_Name() {
        List<String> nameKV=new ArrayList<>();
        List<KhuVucEntity>kvs= (List<KhuVucEntity>) khuVucRepository.findAll();
        for (KhuVucEntity item: kvs) {
            String name = item.getTenKV();
            nameKV.add(name);
        }
        return nameKV;
    }

    @Override
    public KhuVucEntity get_KV_ByName(String name) {
        KhuVucEntity khuVucEntity=new KhuVucEntity();
        List<KhuVucEntity>list= (List<KhuVucEntity>) khuVucRepository.findAll();
        for (KhuVucEntity tl: list) {
            if (tl.getTenKV().equals(name)){
                khuVucEntity=tl;
            }
        }
        return khuVucEntity;
    }

    @Override
    public List<KhuVucEntity> get_limit(List<KhuVucEntity> list, int hienTai,int soPTu) {
        List<KhuVucEntity>limit=new ArrayList<>();
        for (int i = (hienTai-1)*soPTu+1; i <= hienTai*soPTu; i++) {
            if(i>list.size()) {break;}
            limit.add(list.get(i-1));
        }
        return limit;
    }
}
