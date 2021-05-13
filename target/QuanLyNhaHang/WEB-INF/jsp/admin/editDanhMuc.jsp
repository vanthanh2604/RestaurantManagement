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
            <div id="AddProduct" tabindex="1" role="dialog" aria-hidden="false">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <mvc:form autocomplete="off" modelAttribute="DanhMuc" action="/admin/danhmuc/update" method="post" class="form-horizontal">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Cập nhật danh mục</h5>
                            </div>
                            <div class="modal-body">
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Tên danh mục:</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="tenTheLoai" type="text" name="txtcodecus" class="form-control" required="enter"/>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Mô tả</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="moTa" type="text" name="txtphonecus" class="form-control" required="enter"/>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <mvc:input type="hidden" path="id"/>
                                <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i>Lưu</button>
                                <button type="button" class="btn" data-dismiss="modal"><i class="fa fa-undo" aria-hidden="true"></i><a href="/admin/danhmuc/list">Hủy</a></button>
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
