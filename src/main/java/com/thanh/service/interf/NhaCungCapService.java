package com.thanh.service.interf;
import com.thanh.entity.NhaCungCapEntity;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface NhaCungCapService {
    List<NhaCungCapEntity> get_All_NCC();
    void add_NCC(NhaCungCapEntity nhaCungCapEntity);
    void delete_NCC(int id);
    void update_NCC(NhaCungCapEntity nhaCungCapEntity);
    NhaCungCapEntity get_NCC_ByID(int id);
}
