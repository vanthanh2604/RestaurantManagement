package com.thanh.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SanPhamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenSP;
    private String hinhAnh;
    private int soLuong;
    private Double giaTien;
    private String moTa;
    private int trangThai;
    @ManyToOne
    @JoinColumn(name = "idTL")
    private TheLoaiEntity theLoaiEntity;

    @OneToMany(mappedBy = "sanPhamEntity")
    private List<CongThucEntity>congThucEntities;

    @OneToMany(mappedBy = "sanPhamEntity")
    private List<ChiTietHoaDonEntity>chiTietHoaDonEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
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

    public TheLoaiEntity getTheLoaiEntity() {
        return theLoaiEntity;
    }

    public void setTheLoaiEntity(TheLoaiEntity theLoaiEntity) {
        this.theLoaiEntity = theLoaiEntity;
    }

    public List<CongThucEntity> getCongThucEntities() {
        return congThucEntities;
    }

    public void setCongThucEntities(List<CongThucEntity> congThucEntities) {
        this.congThucEntities = congThucEntities;
    }

    public List<ChiTietHoaDonEntity> getChiTietHoaDonEntities() {
        return chiTietHoaDonEntities;
    }

    public void setChiTietHoaDonEntities(List<ChiTietHoaDonEntity> chiTietHoaDonEntities) {
        this.chiTietHoaDonEntities = chiTietHoaDonEntities;
    }
}
