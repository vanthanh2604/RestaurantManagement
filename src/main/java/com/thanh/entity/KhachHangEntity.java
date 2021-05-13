package com.thanh.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class KhachHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenKH;
    private String email;
    private String sdt;
    private Date ngaySinh;
    private String diaChi;
    private  String passWord;

    @OneToMany(mappedBy = "khachHang")
    private List<DonDatBanEntity> donDatBanList;

    @OneToMany(mappedBy = "khachHangEntity")
    private List<HoaDonEntity>hoaDonEntities;

    public KhachHangEntity() {
    }

    public List<HoaDonEntity> getHoaDonEntities() {
        return hoaDonEntities;
    }

    public void setHoaDonEntities(List<HoaDonEntity> hoaDonEntities) {
        this.hoaDonEntities = hoaDonEntities;
    }

    public List<DonDatBanEntity> getDonDatBanList() {
        return donDatBanList;
    }

    public void setDonDatBanList(List<DonDatBanEntity> donDatBanList) {
        this.donDatBanList = donDatBanList;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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
}

