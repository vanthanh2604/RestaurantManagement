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
                    <h2>Contact</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" href="/admin/dondatban/list" aria-selected="true"><i class="fa fa-users" aria-hidden="true"></i> Resercation</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/lienhe/list" aria-selected="true"><i class="fa fa-truck" aria-hidden="true"></i> Contact</a>
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
                                            <th>Full Name</th>
                                            <th>Email</th>
                                            <th>Phone number</th>
                                            <th>Date created</th>
                                            <th>Message</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="item">
                                            <tr>
                                                <td>${item.id}</td>
                                                <td>${item.ten}</td>
                                                <td>${item.email}</td>
                                                <td>${item.sdt}</td>
                                                <td>${item.ngayTao}</td>
                                                <td>${item.noiDung}</td>
                                                <td>
                                                    <a href="#"><i class="ik ik-trash-2 f-16 text-red"></i></a>
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


