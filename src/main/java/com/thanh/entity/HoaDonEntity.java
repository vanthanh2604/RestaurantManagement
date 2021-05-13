package com.thanh.entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class HoaDonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double tongTien;
    private Date ngayTao;
    private String ghiChu;
    private int trangThai;

    @OneToMany(mappedBy = "hoaDonEntity")
    private List<ChiTietHoaDonEntity>chiTietHoaDonEntities;

    @ManyToOne
    @JoinColumn(name = "idNV")
    private NhanVienEntity nhanVienEntity;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "hoaDonEntity")
    private List<BanAnHoaDonEntity>banAnHoaDonEntities;

    @ManyToOne
    @JoinColumn(name = "idKH")
    private KhachHangEntity khachHangEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao() {
        ngayTao=new Date();
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

    public List<ChiTietHoaDonEntity> getChiTietHoaDonEntities() {
        return chiTietHoaDonEntities;
    }

    public void setChiTietHoaDonEntities(List<ChiTietHoaDonEntity> chiTietHoaDonEntities) {
        this.chiTietHoaDonEntities = chiTietHoaDonEntities;
    }

    public NhanVienEntity getNhanVienEntity() {
        return nhanVienEntity;
    }

    public void setNhanVienEntity(NhanVienEntity nhanVienEntity) {
        this.nhanVienEntity = nhanVienEntity;
    }

    public List<BanAnHoaDonEntity> getBanAnHoaDonEntities() {
        return banAnHoaDonEntities;
    }

    public void setBanAnHoaDonEntities(List<BanAnHoaDonEntity> banAnHoaDonEntities) {
        this.banAnHoaDonEntities = banAnHoaDonEntities;
    }

    public KhachHangEntity getKhachHangEntity() {
        return khachHangEntity;
    }

    public void setKhachHangEntity(KhachHangEntity khachHangEntity) {
        this.khachHangEntity = khachHangEntity;
    }
    public String ngay(Date ngay){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String dateString  = df.format(ngay);
        return dateString;
    }
}
