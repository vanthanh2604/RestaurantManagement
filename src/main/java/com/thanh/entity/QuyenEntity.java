package com.thanh.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuyenEntity {
    @Id
    private Integer id;
    private String tenQuyen;

    @OneToMany(mappedBy = "quyenEntity")
    private List<QuyenNhanVienEntity> quyenNhanVienEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public List<QuyenNhanVienEntity> getQuyenNhanVienEntities() {
        return quyenNhanVienEntities;
    }

    public void setQuyenNhanVienEntities(List<QuyenNhanVienEntity> quyenNhanVienEntities) {
        this.quyenNhanVienEntities = quyenNhanVienEntities;
    }
}
