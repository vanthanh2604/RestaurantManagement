<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<%@include file="/common/admin/head.jsp"%>
<body>
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

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
                                <a href="/admin/invoice/back" class="btn btn-success">Back</a>
                            </div>
                        </div>
                    </div>
                    <div class="card-block">
                        <div class="table-responsive">
                            <table class="table table-hover mb-0">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Product name</th>
                                    <th>Image</th>
                                    <th>Amount</th>
                                    <th>Price</th>
                                    <th>Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item">
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>${item.sanPhamEntity.tenSP}</td>
                                        <td><img src="/resources/img/widget/${item.sanPhamEntity.hinhAnh}" alt="" style="height: 50px;width: 50px"></td>
                                        <td>${item.soLuong}</td>
                                        <td>${item.sanPhamEntity.giaTien} <b>$</b></td>
                                        <td>${item.thanhTien} <b>$</b></td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td><b>Total bill</b></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><b>${hoaDon.tongTien} $</b></td>
                                    <td></td>
                                </tr>
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
