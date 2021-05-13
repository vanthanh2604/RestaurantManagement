package com.thanh.dto;

import java.util.Date;

public class HoaDonDTO {
    private Date ngayTao;

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        ngayTao=new Date();
        this.ngayTao = ngayTao;
    }
}
