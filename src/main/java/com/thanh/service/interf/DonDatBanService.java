package com.thanh.service.interf;
import com.thanh.dto.DonDatBanDTO;
import com.thanh.entity.DonDatBanEntity;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface DonDatBanService {
    void create(DonDatBanDTO donDatBanDTO);
    List<DonDatBanEntity>get_All();
    void delete(int id);
    void update_status(int id,int idHd);
    List<DonDatBanEntity>getListChuaDuyet();
    List<DonDatBanEntity>getListDaDuyet();
    List<DonDatBanEntity>getListSearch(String s);
    void update_mode(int id,int mode);
    DonDatBanEntity get_by_Id(int id);
}
