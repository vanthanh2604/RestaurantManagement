package com.thanh.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class BanAnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenBanAn;
    private int trangThai;

    @OneToMany(mappedBy = "banAnEntity")
    private List<BanAnHoaDonEntity> banAnHoaDonEntities;

    @ManyToOne
    @JoinColumn(name = "idKV")
    private KhuVucEntity khuVucEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenBanAn() {
        return tenBanAn;
    }

    public void setTenBanAn(String tenBanAn) {
        this.tenBanAn = tenBanAn;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<BanAnHoaDonEntity> getBanAnHoaDonEntities() {
        return banAnHoaDonEntities;
    }

    public void setBanAnHoaDonEntities(List<BanAnHoaDonEntity> banAnHoaDonEntities) {
        this.banAnHoaDonEntities = banAnHoaDonEntities;
    }

    public KhuVucEntity getKhuVucEntity() {
        return khuVucEntity;
    }

    public void setKhuVucEntity(KhuVucEntity khuVucEntity) {
        this.khuVucEntity = khuVucEntity;
    }
}
