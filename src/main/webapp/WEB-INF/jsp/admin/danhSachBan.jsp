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
                        <h3>Danh sách bàn</h3>
                        <div class="card-header-right">
                            <div class="col-md-7 text-right action">
                                <button class="btn btn-success" data-toggle="modal" data-target="#AddProduct"><i class="fa fa-plus" aria-hidden="true"></i>Thêm bàn mới</button>
                            </div>
                        </div>
                    </div>
                    <div class="card-block">
                        <div class="table-responsive">
                            <table class="table table-hover mb-0">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên bàn</th>
                                    <th>Khu vực</th>
                                    <th>Trạng thái</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listBan}" var="ban">
                                    <tr>
                                        <td>${ban.id}</td>
                                        <td>${ban.tenBanAn}</td>
                                        <td>${ban.khuVucEntity.tenKV}</td>
                                        <td>
                                            <c:if test="${ban.trangThai!=0}">
                                                <div class="p-status bg-green"></div>
                                            </c:if>
                                            <c:if test="${ban.trangThai==0}">
                                                <div class="p-status bg-dark"></div>
                                            </c:if>

                                        </td>
                                        <td>
                                            <a href="/admin/ban/edit/${ban.id}"><i class="ik ik-edit f-16 mr-15 text-green"></i></a>
                                            <a href="/admin/ban/delete/${ban.id}"><i class="ik ik-trash-2 f-16 text-red"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                    <div class="card-block">
                        <ul class="pagination mb-0">
                            <c:forEach var = "i" begin = "1" end = "${tongsotrang}">
                                <c:choose>
                                    <c:when test = "${tht==i}">
                                        <li class="page-item active">
                                            <a class="page-link" href="/admin/ban/list/page=${i}">${i}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item">
                                            <a class="page-link" href="/admin/ban/list/page=${i}">${i}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="AddProduct" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <mvc:form modelAttribute="Ban" action="/admin/ban/create" method="post" class="form-horizontal" autocomplete="off">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Thêm bàn mới</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="row form-group">
                                <div class="col-md-4">
                                    <b>Tên bàn:</b>
                                </div>
                                <div class="col-md-8">
                                    <mvc:input path="tenBanAn" type="text" name="txtcodecus" class="form-control" required="enter"/>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-4">
                                    <b>Trạng thái</b>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-line">
                                        <mvc:select path="trangThai" class="form-control show-tick" required="enter">
                                            <mvc:option value="0" label="Yes"/>
                                            <mvc:option value="1" label="No"/>
                                        </mvc:select>
                                    </div>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-4">
                                    <b>Khu vực</b>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-line">
                                        <mvc:select path="khuVuc" class="form-control show-tick" required="enter">
                                            <option value="">-- Please select --</option>
                                            <mvc:options items="${listKV}"/>
                                        </mvc:select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i>Save</button>
                            <button type="button" class="btn" data-dismiss="modal"><i class="fa fa-undo" aria-hidden="true"></i>Cance</button>
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
