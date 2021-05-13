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
            <div class="row supplier-act act">
                <div class="col-md-5">
                    <h2>Supplier</h2>
                </div>
                <div class="col-md-7 text-right action">
                    <button class="btn btn-success" data-toggle="modal" data-target="#AddSupplierModal"><i class="fa fa-plus" aria-hidden="true"></i> Create supplier</button>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/khachhang/list" aria-selected="true"><i class="fa fa-users" aria-hidden="true"></i> Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="/admin/ncc/list" aria-selected="false"><i class="fa fa-truck" aria-hidden="true"></i> Supplier</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="cus" role="tabpanel">
                            <div class="row filter-search">
                                <div class="col-md-5 form-group">
                                    <input type="text" name="txtcustomer" class="form-control" placeholder="Enter name, suppler code">
                                </div>
                                <div class="col-md-3 form-group">
                                    <select class="form-control">
                                        <option>All</option>
                                        <option>Da tung nhap</option>
                                        <option>Con no</option>
                                    </select>
                                </div>
                                <div class="col-md-2 form-group">
                                    <button class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i> Search</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <table class="table table-striped table-bordered">
                                        <thead class="table-primary">
                                        <tr>
                                            <th>Ma NCC</th>
                                            <th>Ten NCC</th>
                                            <th>SDT</th>
                                            <th>Email</th>
                                            <th>Dia chi</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list_All}" var="ncc">
                                            <tr>
                                                <td>${ncc.id}</td>
                                                <td>${ncc.tenNCC}</td>
                                                <td>${ncc.sdt}</td>
                                                <td>${ncc.email}</td>
                                                <td>${ncc.diaChi}</td>
                                                <td>
                                                    <a href="/admin/ncc/edit/${ncc.id}"><i class="ik ik-edit f-16 mr-15 text-green"></i></a>
                                                    <a href="/admin/ncc/delete/${ncc.id}"><i class="ik ik-trash-2 f-16 text-red"></i></a>
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
            <div class="modal fade" id="AddSupplierModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <mvc:form autocomplete="off" modelAttribute="nhacungcap" action="/admin/ncc/create" method="post" class="form-horizontal">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Add supplier</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="row form-group">
                                <div class="col-md-4">
                                    <b>Supplier name</b>
                                </div>
                                <div class="col-md-8">
                                    <mvc:input path="tenNCC" type="text" name="txtnamesup" placeholder="Enter supplier name" class="form-control"/>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-4">
                                    <b>SDT</b>
                                </div>
                                <div class="col-md-8">
                                    <mvc:input path="sdt" type="text" name="txtphonesup" placeholder="SDT" class="form-control"/>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-4">
                                    <b>Email</b>
                                </div>
                                <div class="col-md-8">
                                    <mvc:input path="email" type="email" name="txtemailsup" placeholder="Email ( example : ngueynthanh.260499@gmail.com)" class="form-control"/>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-4">
                                    <b>Address</b>
                                </div>
                                <div class="col-md-8">
                                    <mvc:input path="diaChi" type="text" name="txtaddresssup" placeholder="Supplier facility address" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save</button>
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
