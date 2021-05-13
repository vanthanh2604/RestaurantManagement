<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>
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
                        <h3>List</h3>
                        <div class="card-header-right">
                            <div class="col-md-7 text-right action">
                                <a href="#" class="btn btn-success">Trở lại</a>
                            </div>
                        </div>
                    </div>
                    <div class="card-block">
                        <div class="table-responsive">
                            <table class="table table-hover mb-0">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Bàn/Khách hàng</th>
                                    <th>Ngày tạo</th>
                                    <th>Tổng tiền</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item">
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>
                                            <c:if test="${item.khachHangEntity==null}">
                                                ${item.banAnHoaDonEntities.get(0).banAnEntity.tenBanAn}
                                            </c:if>
                                            <c:if test="${item.khachHangEntity!=null}">
                                                ${item.khachHangEntity.tenKH}
                                            </c:if>
                                        </td>
                                        <td>${item.ngay(item.ngayTao)}</td>
                                        <td>${item.tongTien}</td>
                                        <td>
                                            <a href="/admin/invoice/detail/${item.id}" type="button" class="btn btn-success btn-rounded">Chi tiết</a>
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
        <%@include file="/common/admin/footer.jsp"%>

    </div>
</div>

<%@include file="/common/admin/scripFooter.jsp"%>
</body>
</html>
