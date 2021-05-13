package com.thanh.entity;

import javax.persistence.*;

@Entity
public class QuyenNhanVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idQuyen")
    private QuyenEntity quyenEntity;

    @ManyToOne
    @JoinColumn(name = "idNV")
    private NhanVienEntity nhanVienEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QuyenEntity getQuyenEntity() {
        return quyenEntity;
    }

    public void setQuyenEntity(QuyenEntity quyenEntity) {
        this.quyenEntity = quyenEntity;
    }

    public NhanVienEntity getNhanVienEntity() {
        return nhanVienEntity;
    }

    public void setNhanVienEntity(NhanVienEntity nhanVienEntity) {
        this.nhanVienEntity = nhanVienEntity;
    }
}
