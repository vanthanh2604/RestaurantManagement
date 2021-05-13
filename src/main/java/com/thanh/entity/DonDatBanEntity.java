package com.thanh.entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class DonDatBanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenKH;
    private String email;
    private String sdt;
    private Date ngayDatBan;
    private Date ngayTao;
    private String ghiChu;
    private int trangThai;
    private int soNguoi;
    private int idHD;

    @ManyToOne
    @JoinColumn(name = "idKH")
    private KhachHangEntity khachHang;

    public DonDatBanEntity() {
    }

    public KhachHangEntity getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHangEntity khachHang) {
        this.khachHang = khachHang;
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

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayDatBan() {
        return ngayDatBan;
    }

    public void setNgayDatBan(Date ngayDatBan) {
        this.ngayDatBan = ngayDatBan;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String ngay(Date ngay){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String dateString  = df.format(ngay);
        return dateString;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }
}
