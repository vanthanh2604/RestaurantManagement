package com.thanh.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class NhaCungCapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenNCC;
    private String diaChi;
    private String sdt;
    private String email;

    @OneToMany(mappedBy = "nhaCungCapEntity")
    private List<PhieuNhapEntity> phieuNhapEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PhieuNhapEntity> getPhieuNhapEntities() {
        return phieuNhapEntities;
    }

    public void setPhieuNhapEntities(List<PhieuNhapEntity> phieuNhapEntities) {
        this.phieuNhapEntities = phieuNhapEntities;
    }
}
