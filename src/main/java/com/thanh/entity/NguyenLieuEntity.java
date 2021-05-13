package com.thanh.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class NguyenLieuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenNL;
    private String hinhAnh;
    private int soLuong;
    private Double giaTien;
    private String moTa;
    private int trangThai;

    @OneToMany(mappedBy = "nguyenLieuEntity")
    private List<ChiTietPhieuNhapEntity>chiTietPhieuNhapEntities;

    @OneToMany(mappedBy = "nguyenLieuEntity")
    private List<CongThucEntity>congThucEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<ChiTietPhieuNhapEntity> getChiTietPhieuNhapEntities() {
        return chiTietPhieuNhapEntities;
    }

    public void setChiTietPhieuNhapEntities(List<ChiTietPhieuNhapEntity> chiTietPhieuNhapEntities) {
        this.chiTietPhieuNhapEntities = chiTietPhieuNhapEntities;
    }

    public List<CongThucEntity> getCongThucEntities() {
        return congThucEntities;
    }

    public void setCongThucEntities(List<CongThucEntity> congThucEntities) {
        this.congThucEntities = congThucEntities;
    }
}
