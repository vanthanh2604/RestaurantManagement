package com.thanh.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class KhuVucEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenKV;
    private int trangThai;

    @OneToMany(mappedBy = "khuVucEntity")
    private List<BanAnEntity>banAnEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenKV() {
        return tenKV;
    }

    public void setTenKV(String tenKV) {
        this.tenKV = tenKV;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<BanAnEntity> getBanAnEntities() {
        return banAnEntities;
    }

    public void setBanAnEntities(List<BanAnEntity> banAnEntities) {
        this.banAnEntities = banAnEntities;
    }
}
