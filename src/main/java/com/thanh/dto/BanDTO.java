package com.thanh.dto;

import com.thanh.entity.HoaDonEntity;
import com.thanh.entity.KhuVucEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BanDTO {
    private Integer id;
    private String tenBanAn;
    private int trangThai;
    private String khuVuc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenBanAn() {
        return tenBanAn;
    }

    public void setTenBanAn(String tenBanAn) {
        this.tenBanAn = tenBanAn;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }
}
