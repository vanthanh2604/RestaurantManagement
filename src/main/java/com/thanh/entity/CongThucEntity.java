package com.thanh.entity;

import javax.persistence.*;

@Entity
public class CongThucEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idNL")
    private NguyenLieuEntity nguyenLieuEntity;

    @ManyToOne
    @JoinColumn(name = "idSP")
    private SanPhamEntity sanPhamEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NguyenLieuEntity getNguyenLieuEntity() {
        return nguyenLieuEntity;
    }

    public void setNguyenLieuEntity(NguyenLieuEntity nguyenLieuEntity) {
        this.nguyenLieuEntity = nguyenLieuEntity;
    }

    public SanPhamEntity getSanPhamEntity() {
        return sanPhamEntity;
    }

    public void setSanPhamEntity(SanPhamEntity sanPhamEntity) {
        this.sanPhamEntity = sanPhamEntity;
    }
}
