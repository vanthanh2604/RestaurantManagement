package com.thanh.entity;

import javax.persistence.*;

@Entity
public class BanAnHoaDonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idBan")
    private BanAnEntity banAnEntity;

    @ManyToOne
    @JoinColumn(name = "idHD")
    private HoaDonEntity hoaDonEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BanAnEntity getBanAnEntity() {
        return banAnEntity;
    }

    public void setBanAnEntity(BanAnEntity banAnEntity) {
        this.banAnEntity = banAnEntity;
    }

    public HoaDonEntity getHoaDonEntity() {
        return hoaDonEntity;
    }

    public void setHoaDonEntity(HoaDonEntity hoaDonEntity) {
        this.hoaDonEntity = hoaDonEntity;
    }
}
