package com.thanh.repository;

import com.thanh.entity.DonDatBanEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DonDatBanRepository extends CrudRepository<DonDatBanEntity,Integer> {
    @Query("select d from DonDatBanEntity d where d.trangThai=0")
    List<DonDatBanEntity>findChuaDuyet();
    @Query("select d from DonDatBanEntity d where d.trangThai=1")
    List<DonDatBanEntity>findDaDuyet();
    @Query("select d from DonDatBanEntity d where d.sdt like %?1% and d.trangThai=1")
    List<DonDatBanEntity>searchList(String s);
    @Query("select d from DonDatBanEntity d where d.idHD=?1")
    DonDatBanEntity findByIdHd(int idHd);
}
