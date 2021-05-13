package com.thanh.repository;

import com.thanh.entity.NhanVienEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NhanVienRepository extends CrudRepository<NhanVienEntity,Integer> {
    @Query("select n from NhanVienEntity n where n.username=?1 and n.passWord=?2")
    NhanVienEntity findNv(String username,String pass);
}
