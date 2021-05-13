package com.thanh.repository;

import com.thanh.entity.ChiTietHoaDonEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChiTietHoaDonRepository extends CrudRepository<ChiTietHoaDonEntity,Integer> {
    @Query("SELECT c FROM ChiTietHoaDonEntity c where c.hoaDonEntity.id=?1 and c.sanPhamEntity.id=?2")
    ChiTietHoaDonEntity get_CTHD_By_IdHD_IdSP(int idHD,int SP);

    @Query("SELECT c FROM ChiTietHoaDonEntity c where c.hoaDonEntity.id=?1")
    List<ChiTietHoaDonEntity> get_CTHD_By_IdHD(int idHD);

    @Query("SELECT c.id from ChiTietHoaDonEntity c where c.hoaDonEntity.id=?1 and c.sanPhamEntity.id=?2")
    int getId_CTHD_By_IdHD_IdSP(int idHD,int idSP);
    @Modifying
    @Query("delete from ChiTietHoaDonEntity c where c.hoaDonEntity.id=:idHd")
    void deleteByIdHd(@Param("idHd")  int idHD);
}
