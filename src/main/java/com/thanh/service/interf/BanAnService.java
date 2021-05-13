package com.thanh.service.interf;
import com.thanh.dto.BanDTO;
import com.thanh.entity.BanAnEntity;
import com.thanh.entity.KhuVucEntity;


import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface BanAnService {
    List<BanAnEntity> get_All_Ban();
    void add_Ban(BanAnEntity banAnEntity);
    void delete_Ban(Integer id);
    BanAnEntity get_BanById(Integer id);
    void update_Ban(BanDTO banDTO, KhuVucEntity khuVucEntity);
    List<BanAnEntity>get_limit(List<BanAnEntity> list, int hienTai, int soPTu);
    List<BanAnEntity>search(String string);
    void update_status(int idBan,int status);
    int get_total_table();
    List<BanAnEntity>get_Ban_By_IdKV(int id);
    List<BanAnEntity>get_Ban_Trong();
}
