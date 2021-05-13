package com.thanh.repository;

import com.thanh.entity.SanPhamEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SanPhamRepository extends CrudRepository<SanPhamEntity,Integer> {
    @Query("SELECT sp FROM SanPhamEntity sp ORDER BY sp.id  DESC")
    List<SanPhamEntity> findAllDesc();

    @Query("SELECT sp FROM SanPhamEntity sp JOIN TheLoaiEntity tl ON sp.theLoaiEntity.id=tl.id" +
            " WHERE sp.tenSP LIKE %?1% OR tl.tenTheLoai LIKE %?1% ORDER BY sp.id  DESC")
    List<SanPhamEntity>getSanPhamEntitiesByName(String name);

    @Query("SELECT sp FROM SanPhamEntity sp JOIN TheLoaiEntity tl ON sp.theLoaiEntity.id=tl.id " +
            "WHERE tl.id=?1")
    List<SanPhamEntity>getSPTL(int id);
}
