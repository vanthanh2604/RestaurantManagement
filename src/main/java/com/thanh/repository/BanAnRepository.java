package com.thanh.repository;

import com.thanh.entity.BanAnEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BanAnRepository extends CrudRepository<BanAnEntity,Integer> {
    @Query("SELECT b FROM BanAnEntity b JOIN KhuVucEntity kv ON b.khuVucEntity.id=kv.id" +
            " WHERE b.tenBanAn LIKE %?1% OR kv.tenKV LIKE %?1%")
    List<BanAnEntity>getBanAnEntitiesByName(String name);

    @Query("select count(b.id) from BanAnEntity b")
    int total_table();

    @Query("select b from BanAnEntity b where b.khuVucEntity.id=?1")
    List<BanAnEntity>get_Ban_ByIdKV(int id);

    @Query("select b from BanAnEntity b where b.trangThai=0")
    List<BanAnEntity>findBanTrong();
}
