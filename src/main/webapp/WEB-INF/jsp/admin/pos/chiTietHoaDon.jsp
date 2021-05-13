<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<%@include file="/common/admin/head.jsp"%>
<body>
<div class="wrapper">
    <%@include file="/common/admin/header.jsp"%>
    <div class="page-wrap">
        <%@include file="/common/admin/menu.jsp"%>
        <div class="main-content">
            <div class="col-xl-11 col-md-6">
                <div class="card table-card">
                    <div class="card-header">
                        <h3>Chi tiết hóa đơn</h3>
                        <div class="col-md-5">
                            <h2>${table.tenBanAn}</h2>
                        </div>
                        <div class="card-header-right">
                            <div class="col-md-7 text-right action">
                                <a href="/admin/pos/table" class="btn btn-success"></i>Quay lại</a>
                            </div>
                        </div>
                    </div>
                    <div class="card-block">
                        <div class="table-responsive">
                            <table class="table table-hover mb-0">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Hình ảnh</th>
                                    <th>Số lượng</th>
                                    <th>Giá</th>
                                    <th>Số tiền</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listSP}" var="item">
                                    <tr data-idBan="${table.id}" data-idSP="${item.sanPhamEntity.id}" data-price="${item.sanPhamEntity.giaTien}" data-qty=""${item.soLuong}>
                                        <td>${item.id}</td>
                                        <td>${item.sanPhamEntity.tenSP}</td>
                                        <td><img src="/resources/img/widget/${item.sanPhamEntity.hinhAnh}" alt="" style="height: 50px;width: 50px"></td>
                                        <td><input value="${item.soLuong}" type="number" min="1" style="width: 120px"></td>
                                        <td>${item.sanPhamEntity.giaTien} $</td>
                                        <td class="amt">${item.thanhTien} $</td>
                                        <td>
                                            <a type="button" class="btn btn-danger btn-rounded"><label class="btn-delete-product-order-detail">Xóa</label></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td><b>Tổng tiền:</b></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><b id="total-bill">${hoaDon.tongTien}</b> <b>$</b></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                        <a href="/admin/pos/payment/${table.id}/${hoaDon.id}" type="button" class="btn btn-outline-success btn-rounded"><label class="btn-payment">Thanh toán</label></a>

                </div>
            </div>
        </div>
        <%@include file="/common/admin/footer.jsp"%>

    </div>
</div>

<%@include file="/common/admin/scripFooter.jsp"%>
</body>
</html>
