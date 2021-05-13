package com.thanh.entity;

import javax.persistence.*;

@Entity
public class ChiTietPhieuNhapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int soLuong;
    private Double thanhTien;

    @ManyToOne
    @JoinColumn(name = "idPN")
    private PhieuNhapEntity phieuNhapEntity;

    @ManyToOne
    @JoinColumn(name = "idNL")
    private NguyenLieuEntity nguyenLieuEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public PhieuNhapEntity getPhieuNhapEntity() {
        return phieuNhapEntity;
    }

    public void setPhieuNhapEntity(PhieuNhapEntity phieuNhapEntity) {
        this.phieuNhapEntity = phieuNhapEntity;
    }

    public NguyenLieuEntity getNguyenLieuEntity() {
        return nguyenLieuEntity;
    }

    public void setNguyenLieuEntity(NguyenLieuEntity nguyenLieuEntity) {
        this.nguyenLieuEntity = nguyenLieuEntity;
    }
}
