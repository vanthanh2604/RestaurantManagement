package com.thanh.service.interf;
import com.thanh.entity.KhuVucEntity;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface KhuVucService {
    List<KhuVucEntity> get_All_KV();
    List<String> get_All_KV_Name();
    KhuVucEntity get_KV_ById(int id);
    void add_KhuVuc(KhuVucEntity khuVucEntity);
    void delete_KhuVuc(int id);
    void update_KhuVuc(KhuVucEntity khuVucEntity);
    KhuVucEntity get_KV_ByName(String name);
    List<KhuVucEntity>get_limit(List<KhuVucEntity> list, int hienTai,int soPTu);
}
