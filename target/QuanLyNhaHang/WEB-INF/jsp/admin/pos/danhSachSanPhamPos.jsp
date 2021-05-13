<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<%@include file="/common/admin/head.jsp"%>
<body>
<!--[if lt IE 8]>
<![endif]-->

<div class="wrapper">
    <%@include file="/common/admin/header.jsp"%>
    <div class="page-wrap">
        <%@include file="/common/admin/menu.jsp"%>
        <div class="main-content">
            <div class="col-xl-11 col-md-6">
                <div class="row customer-act act">
                    <div class="col-md-5">
                        <h2>${table.tenBanAn}</h2>
                    </div>
                    <div class="col-md-7 text-right action">
                        <div class="search-container">
                            <mvc:form modelAttribute="search" autocomplete="off" action="${pageContext.request.contextPath }/admin/pos/list-product/search" method="post">
                                <mvc:input path="string" type="text" placeholder="Search.." name="search"/>
                                <input hidden name="idBan" value="${table.id}">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </mvc:form>
                        </div>
                    </div>
                </div>

                <div class="card table-card">
                    <div class="card-header">
                        <h3>Danh sách sản phẩm</h3>
                        <div class="card-header-right">
                            <div class="col-md-7 text-right action">
                                <a href="/admin/pos/table" class="btn btn-success"><i class="fa fa-plus" aria-hidden="true"></i>Quay lại</a>
                            </div>
                        </div>
                    </div>
                    <div class="card-block">
                        <div class="table-responsive">
                            <table class="table table-hover mb-0">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Hình ảnh</th>
                                    <th>Giá</th>
                                    <th>Danh mục</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listSP}" var="sp">
                                    <tr>
                                        <td>${sp.id}</td>
                                        <td>${sp.tenSP}</td>
                                        <td><img src="/resources/img/widget/${sp.hinhAnh}" alt="" style="height: 50px;width: 50px"></td>
                                        <td>${sp.giaTien} $</td>
                                        <td>${sp.theLoaiEntity.tenTheLoai}</td>
                                        <td>
                                            <div data-idBan="${table.id}" data-idSP="${sp.id}">
                                                <a type="button" class="btn btn-primary btn-rounded"><label class="btn-add-to-order">Thêm</label></a>
                                            </div>
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
