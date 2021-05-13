<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html lang="vi">
<%@include file="/common/admin/head.jsp"%>
<body>
<div class="wrapper">
    <%@include file="/common/admin/header.jsp"%>
    <div class="page-wrap">
        <%@include file="/common/admin/menu.jsp"%>
        <div class="main-content">
            <div class="row customer-act act">
                <div class="col-md-5">
                    <h2>Danh sách đơn đặt bàn</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" href="/admin/dondatban/list" aria-selected="true"><i class="fa fa-table" aria-hidden="true"></i> Danh sách chưa xử lý</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/dondatban/list/duyet" aria-selected="true"><i class="fa fa-table" aria-hidden="true"></i> Danh sách xử lý</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="cus" role="tabpanel">
                            <div class="row">
                                <div class="col-md-12">
                                    <table class="table table-striped table-bordered">
                                        <thead table-primary>
                                        <tr>
                                            <th>ID</th>
                                            <th>Tên khách hàng</th>
                                            <th>Số điện thoại</th>
                                            <th>Số người</th>
                                            <th>Ngày đặt</th>
                                            <th>Lời nhắn</th>
                                            <th>Tình trạng</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="item">
                                            <tr data-id="${item.id}" data-idHd="${item.idHD}">
                                                <td>${item.id}</td>
                                                <td>${item.khachHang.tenKH}</td>
                                                <td>${item.sdt}</td>
                                                <td>${item.soNguoi}</td>
                                                <td>${item.ngay(item.ngayDatBan)}</td>
                                                <td>${item.ghiChu}</td>
                                                <c:if test="${item.trangThai==0}">
                                                    <td>Chưa duyệt</td>
                                                </c:if>
                                                <c:if test="${item.trangThai==1}">
                                                    <td>Đã duyệt</td>
                                                </c:if>

                                                <td>
                                                    <a <c:if test="${item.trangThai==1}">hidden</c:if> type="button"  class="btn btn-success btn-rounded btn-duyet">Duyệt</a>
                                                    <a type="button" href="/admin/dondatban/detail/${item.idHD}"  class="btn btn-info btn-rounded">Xem</a>
                                                    <a href="/admin/dondatban/delete/${item.id}" class="btn btn-danger btn-rounded">Hủy</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/common/admin/footer.jsp"%>

    </div>
</div>

<%@include file="/common/admin/scripFooter.jsp"%>
</body>
</html>


