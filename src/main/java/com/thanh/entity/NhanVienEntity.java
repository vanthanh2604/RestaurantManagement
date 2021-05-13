package com.thanh.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class NhanVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenNV;
    private String email;
    private String sdt;
    private Date ngaySinh;
    private String passWord;
    private String username;

    @OneToMany(mappedBy = "nhanVienEntity")
    private List<QuyenNhanVienEntity> quyenNhanVienEntities;

    @OneToMany(mappedBy = "nhanVienEntity")
    private List<PhieuNhapEntity>phieuNhapEntities;

    @OneToMany(mappedBy = "nhanVienEntity")
    private List<HoaDonEntity>hoaDonEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<QuyenNhanVienEntity> getQuyenNhanVienEntities() {
        return quyenNhanVienEntities;
    }

    public void setQuyenNhanVienEntities(List<QuyenNhanVienEntity> quyenNhanVienEntities) {
        this.quyenNhanVienEntities = quyenNhanVienEntities;
    }

    public List<PhieuNhapEntity> getPhieuNhapEntities() {
        return phieuNhapEntities;
    }

    public void setPhieuNhapEntities(List<PhieuNhapEntity> phieuNhapEntities) {
        this.phieuNhapEntities = phieuNhapEntities;
    }

    public List<HoaDonEntity> getHoaDonEntities() {
        return hoaDonEntities;
    }

    public void setHoaDonEntities(List<HoaDonEntity> hoaDonEntities) {
        this.hoaDonEntities = hoaDonEntities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
