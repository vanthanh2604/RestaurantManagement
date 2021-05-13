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
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-4">
                        <h3></h3>
                    </div>
                    <div class="col-md-4">
                        <h3 class="bg-aqua">QUẢN LÝ BÁN HÀNG</h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <mvc:form modelAttribute="search" autocomplete="off" action="/admin/pos/listddb/search" method="post">
                        <mvc:input path="string" type="text" placeholder="Search.." name="search"/>
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </mvc:form>
                </div>
            </div><br/>
            <div class="row customer-act act">
                <div class="col-md-5">
                    <h4>Danh sách đơn đặt bàn</h4>
                </div>
                <div class="col-md-7">
                    <a href="/admin/pos/table" class="float-right btn btn-info">Quay lại</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
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
                                            <tr data-id="${item.id}" data-idhd="${item.idHD}">
                                                <td>${item.id}</td>
                                                <td>${item.khachHang.tenKH}</td>
                                                <td>${item.sdt}</td>
                                                <td>${item.soNguoi}</td>
                                                <td>${item.ngay(item.ngayDatBan)}</td>
                                                <td>${item.ghiChu}</td>
                                                <c:if test="${item.trangThai==1}">
                                                    <td>Đã duyệt</td>
                                                </c:if>

                                                <td>
                                                    <a href="/admin/pos/listddb/chonban/${item.idHD}" class="btn btn-success">Chọn bàn</a>
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


