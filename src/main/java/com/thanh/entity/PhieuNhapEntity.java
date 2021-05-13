package com.thanh.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class PhieuNhapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date ngayNhap;
    private Double tongTien;

    @ManyToOne
    @JoinColumn(name = "idNCC")
    private NhaCungCapEntity nhaCungCapEntity;

    @ManyToOne
    @JoinColumn(name = "idNV")
    private NhanVienEntity nhanVienEntity;

    @OneToMany(mappedBy = "phieuNhapEntity")
    private List<ChiTietPhieuNhapEntity> chiTietPhieuNhapEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public NhaCungCapEntity getNhaCungCapEntity() {
        return nhaCungCapEntity;
    }

    public void setNhaCungCapEntity(NhaCungCapEntity nhaCungCapEntity) {
        this.nhaCungCapEntity = nhaCungCapEntity;
    }

    public NhanVienEntity getNhanVienEntity() {
        return nhanVienEntity;
    }

    public void setNhanVienEntity(NhanVienEntity nhanVienEntity) {
        this.nhanVienEntity = nhanVienEntity;
    }

    public List<ChiTietPhieuNhapEntity> getChiTietPhieuNhapEntityList() {
        return chiTietPhieuNhapEntityList;
    }

    public void setChiTietPhieuNhapEntityList(List<ChiTietPhieuNhapEntity> chiTietPhieuNhapEntityList) {
        this.chiTietPhieuNhapEntityList = chiTietPhieuNhapEntityList;
    }
}
