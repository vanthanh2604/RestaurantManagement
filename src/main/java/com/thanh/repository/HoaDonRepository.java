package com.thanh.repository;

import com.thanh.entity.HoaDonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HoaDonRepository extends CrudRepository<HoaDonEntity,Integer> {
    @Query(nativeQuery=true, value="SELECT * FROM hoaDonEntity hd order by hd.id desc limit 1")
    HoaDonEntity getHoaDon();

    @Query(nativeQuery=true, value="select hd.* from hoadonentity hd join bananhoadonentity b on hd.id= b.idHD " +
            "where b.idBan=?1 and (hd.trangThai=4 or hd.trangThai=0);")
    HoaDonEntity getHoaDonByIdBan(int idBan);

    @Query("select count(b.id) from HoaDonEntity b")
    int total_invoice();

    @Query(nativeQuery=true, value="select * from hoadonentity hd where ngayTao between ?1 and ?2")
    List<HoaDonEntity>findByDate(String from, String to);

}
