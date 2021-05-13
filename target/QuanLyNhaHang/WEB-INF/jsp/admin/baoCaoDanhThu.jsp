<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8"%>
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
                <h3>Report</h3>
            </div>
            <div class="col-xl-11 col-md-6">
                <div class="card table-card">
                    <mvc:form modelAttribute="search" action="/admin/report/result" method="post">
                        <div class="card-header">
                                <div class="col-sm-5 col-xl-3">
                                    <label>Từ ngày</label>
                                    <mvc:input path="from" class="form-control" type="date"/>
                                </div>
                                <div class="col-sm-5 col-xl-3">
                                    <label>Đến ngày</label>
                                    <mvc:input path="to" class="form-control" type="date"/>
                                </div>
                                <div class="col-sm-3 col-xl-2">
                                    <br/>
                                    <button type="submit" class="btn btn-primary btn-rounded">Primary</button>
                                </div>
                            <div class="col-sm-6 col-xl-4">
                                <br/><br/>
                                <p><b>Total:</b> ${total} $</p>
                            </div>
                        </div>
                    </mvc:form>
                    <div class="card-block">
                        <div class="table-responsive">
                            <table class="table table-hover mb-0">
                                <thead>
                                <tr>
                                    <th><b>ID</b></th>
                                    <th><b>Table</b></th>
                                    <th><b>Total bill</b></th>
                                    <th><b>Data create</b></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item">
                                    <tr>
                                        <td>${item.id}</td>
<%--                                        <td>${item.banAnHoaDonEntities.get(0).banAnEntity.tenBanAn}</td>--%>
                                        <td></td>
                                        <td>${item.tongTien}</td>
                                        <td>${item.ngay(item.ngayTao)}</td>
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
