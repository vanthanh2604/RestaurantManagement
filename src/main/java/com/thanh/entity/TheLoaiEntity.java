package com.thanh.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class TheLoaiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenTheLoai;
    private String moTa;
    @OneToMany(mappedBy = "theLoaiEntity")
    private List<SanPhamEntity> sanPhams;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<SanPhamEntity> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPhamEntity> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
