package com.thanh.entity;

import javax.persistence.*;

@Entity
public class ChiTietHoaDonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int soLuong;
    private Double thanhTien;
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "idSP")
    private SanPhamEntity sanPhamEntity;

    @ManyToOne
    @JoinColumn(name = "idHD")
    private HoaDonEntity hoaDonEntity;

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

    public void setThanhTien() {
        Double thanhTien= this.soLuong*this.getSanPhamEntity().getGiaTien();
        this.thanhTien = thanhTien;
    }
    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public SanPhamEntity getSanPhamEntity() {
        return sanPhamEntity;
    }

    public void setSanPhamEntity(SanPhamEntity sanPhamEntity) {
        this.sanPhamEntity = sanPhamEntity;
    }

    public HoaDonEntity getHoaDonEntity() {
        return hoaDonEntity;
    }

    public void setHoaDonEntity(HoaDonEntity hoaDonEntity) {
        this.hoaDonEntity = hoaDonEntity;
    }
}
