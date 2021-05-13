package com.thanh.repository;

import com.thanh.entity.KhachHangEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KhachHangRepository extends CrudRepository<KhachHangEntity,Integer> {
    @Query("select k from KhachHangEntity k where k.email=?1 and k.passWord=?2")
    KhachHangEntity findKH(String email, String pass);

    @Query("select k from KhachHangEntity k where k.email=?1")
    KhachHangEntity findKhByEmail(String email);
}
