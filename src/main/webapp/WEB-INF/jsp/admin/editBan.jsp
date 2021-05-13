<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Trang quản trị</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="/resources/img/favicon.ico" type="image/x-icon" />

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300,400,600,700,800" rel="stylesheet">

    <link rel="stylesheet" href="/resources/plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="/resources/plugins/icon-kit/dist/css/iconkit.min.css">
    <link rel="stylesheet" href="/resources/plugins/ionicons/dist/css/ionicons.min.css">
    <link rel="stylesheet" href="/resources/plugins/perfect-scrollbar/css/perfect-scrollbar.css">
    <link rel="stylesheet" href="/resources/plugins/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="/resources/plugins/jvectormap/jquery-jvectormap.css">
    <link rel="stylesheet" href="/resources/plugins/tempusdominus-bootstrap-4/build/css/tempusdominus-bootstrap-4.min.css">
    <link rel="stylesheet" href="/resources/plugins/weather-icons/css/weather-icons.min.css">
    <link rel="stylesheet" href="/resources/plugins/c3/c3.min.css">
    <link rel="stylesheet" href="/resources/plugins/owl.carousel/dist/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="/resources/plugins/owl.carousel/dist/assets/owl.theme.default.min.css">
    <link rel="stylesheet" href="/resources/dist/css/theme.min.css">
    <script src="/resources/src/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
<div class="wrapper">
    <%@include file="/common/admin/header.jsp"%>
    <div class="page-wrap">
        <%@include file="/common/admin/menu.jsp"%>
        <div class="main-content">
            <div id="AddProduct" tabindex="1" role="dialog" aria-hidden="false">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <mvc:form autocomplete="off" modelAttribute="Ban" action="/admin/ban/update" method="post" class="form-horizontal">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Edit Table</h5>
                            </div>
                            <div class="modal-body">
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Table name:</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="tenBanAn" type="text" name="txtcodecus" class="form-control" required="enter"/>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Status</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="trangThai" type="text" name="txtnamecus" class="form-control"/>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Region</b>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-line">
                                            <mvc:select path="khuVuc" class="form-control show-tick" required="enter">
                                                <mvc:options items="${listKV}"/>
                                            </mvc:select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <mvc:input type="hidden" path="id"/>
                                <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i>Save</button>
                                <button type="button" class="btn" data-dismiss="modal"><i class="fa fa-undo" aria-hidden="true"></i><a href="/admin/ban/list">Cance</a></button>
                            </div>
                        </mvc:form>
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
