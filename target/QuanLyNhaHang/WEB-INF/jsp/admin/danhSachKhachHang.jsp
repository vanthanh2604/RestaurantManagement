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
            <div class="row customer-act act">
                <div class="col-md-5">
                    <h2>Khách hàng</h2>
                </div>
                <div class="col-md-7 text-right action">
                    <button class="btn btn-success" data-toggle="modal" data-target="#AddCustomerModal"><i class="fa fa-plus" aria-hidden="false"></i> Create customers</button>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" href="/admin/khachhang/list" aria-selected="true"><i class="fa fa-users" aria-hidden="true"></i> Khách hàng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/ncc/list" aria-selected="true"><i class="fa fa-truck" aria-hidden="true"></i> Supplier</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="cus" role="tabpanel">
                            <div class="row filter-search">
                                <div class="col-md-5 form-group">
                                    <input type="text" name="txtcustomer" class="form-control" placeholder="Enter name, code customer">
                                </div>
                                <div class="col-md-2 form-group">
                                    <button class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i> Tìm kiếm</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <table class="table table-striped table-bordered">
                                        <thead class="table-primary">
                                            <tr>
                                                <th>ID</th>
                                                <th>Tên khách hàng</th>
                                                <th>Số điện thoại</th>
                                                <th>Email</th>
                                                <th>Địa chỉ</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listAll}" var="kh">
                                            <tr>
                                                <td>${kh.id}</td>
                                                <td>${kh.tenKH}</td>
                                                <td>${kh.sdt}</td>
                                                <td>${kh.email}</td>
                                                <td>${kh.diaChi}</td>
                                                <td>
                                                    <a href="/admin/khachhang/edit/${kh.id}"><i class="ik ik-edit f-16 mr-15 text-green"></i></a>
                                                    <a href="/admin/khachhang/delete/${kh.id}"><i class="ik ik-trash-2 f-16 text-red"></i></a>
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
            <div class="modal fade" id="AddCustomerModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <mvc:form autocomplete="off" modelAttribute="khachhang" action="/admin/khachhang/create" method="post" class="form-horizontal">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" >Thêm khách hàng mới</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Customer name</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="tenKH" type="text" name="txtnamecus" class="form-control" required="enter"/>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>SDT</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="sdt" type="text" name="txtphonecus" class="form-control" required="enter"/>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Email</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="email" type="email" name="txtemailcus" class="form-control" required="enter"/>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Address</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="diaChi" type="text" name="txtaddrescus" class="form-control" required="enter"/>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success" ><i class="fa fa-floppy-o" aria-hidden="true"></i> Save</button>
                                <button type="button" class="btn" data-dismiss="modal"><i class="fa fa-undo" aria-hidden="true"></i> Cance</button>
                            </div>
                        </div>
                    </mvc:form>
                </div>
            </div>
        </div>
        <%@include file="/common/admin/footer.jsp"%>

    </div>
</div>

<%@include file="/common/admin/scripFooter.jsp"%>
</body>
</html>
