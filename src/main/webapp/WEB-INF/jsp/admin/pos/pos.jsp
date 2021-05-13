<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<%@include file="/common/admin/head.jsp"%>
<style>
    .statusa{
        background: grey;
    }
    .statusb{
        background: #9e1f1f;
    }
    .list-filter .list-filter-content{
        padding-top:20px;
        margin-bottom: 20px;
    }
    .table-list .table-list-content ul{
        list-style: none;
        padding: 0;
        margin: 0;
    }
    .table-list .table-list-content ul li{
        float: left;
        line-height: 55px;
        margin:6px;
        height: 125px;
        color: #fff;
        border-radius:3px;
        width: calc(100% * (1/4) - 12px );
        cursor: pointer;
        text-align: center;
        position: relative;
        vertical-align: middle;
    }
    .table-list .table-list-content ul li.tb-active{
        background:#FF5823;
    }
    .table-list .table-list-content ul li.inused{
        background:#F94646;
    }
    @media only screen and (max-width: 600px) {
        .table-list .table-list-content ul li{
            width: calc(100% * (1/3) - 12px );
        }
    }
</style>
<body>
<div class="wrapper">
    <%@include file="/common/admin/header.jsp"%>
    <div class="page-wrap">
        <%@include file="/common/admin/menu.jsp"%>
            <div class="main-content">
                <div class="col-xl-11 col-md-6">
                    <div class="row">
                        <div class="col-md-4">
                            <h3></h3>
                        </div>
                        <div class="col-md-4">
                            <h3 class="bg-aqua">QUẢN LÝ BÁN HÀNG</h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <mvc:form modelAttribute="search" autocomplete="off" action="/admin/pos/table/search" method="post">
                                <mvc:input path="string" type="text" placeholder="Tìm kiếm.." name="search"/>
                                <button type="submit" class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i> Tìm kiếm</button>
                            </mvc:form>
                        </div>
                        <div class="col-md-4"></div>
                        <c:if test="${mode==0}">
                            <div class="float-right col-md-4">
                                <a href="/admin/pos/listdbb" class="float-right btn btn-google"><i class="fa fa-table"></i>Danh sách đơn đặt bàn</a>
                            </div>
                        </c:if>
                        <c:if test="${mode==1}">
                            <div class="float-right col-md-4">
                                <a href="/admin/pos/listdbb" class="float-right btn btn-info">Quay lại</a>
                            </div>
                        </c:if>
                    </div>

                    <div class="row list-filter">
                        <div class="col-md list-filter-content">
                            <a href="/admin/pos/table" class="btn btn-primary">All</a>
                            <c:forEach items="${listKV}" var="item">
                            <a href="/admin/pos/table/kv=${item.id}" class="btn btn-primary">${item.tenKV}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="row table-list">
                        <div class="col-md table-list-content">
                            <ul>
                                <c:forEach var="item" items="${listBan}">

                                    <li <c:if test="${item.trangThai==0}">class="statusa"</c:if> <c:if test="${item.trangThai!=0}">class="statusb"</c:if>>
                                    <h4>${item.tenBanAn}</h4>
                                    <h5>${item.khuVucEntity.tenKV}</h5>
                                    <c:if test="${mode==0}">
                                        <c:if test="${item.trangThai==1}">
                                            <a href="/admin/pos/order-detail/table=${item.id}" type="button" class="btn btn-success btn-rounded">Order</a>
                                        </c:if>
                                        <c:if test="${item.trangThai==0}">
                                            <a onclick="thongbao()" type="button" class="btn btn-success btn-rounded">Order</a>
                                        </c:if>
                                        <a href="/admin/pos/list-product/table/${item.id}" type="button" class="btn btn-danger btn-rounded">Gọi món</a>
                                    </c:if>
                                    <c:if test="${mode==1}">
                                        <a href="/admin/pos/chon/${idHd}/${item.id}" type="button" class="btn btn-success btn-rounded">Chọn</a>
                                    </c:if>
                                </li>
                                </c:forEach>
                            </ul>
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
