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
                        <mvc:form autocomplete="off" modelAttribute="SanPham" action="/admin/sanpham/update" method="post" class="form-horizontal">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Cập nhật sản phẩm</h5>
                            </div>
                            <div class="modal-body">
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Tên sản phẩm:</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="tenSP" type="text" name="txtcodecus" class="form-control" required="enter"/>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Số lượng</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="soLuong" type="text" name="txtnamecus" class="form-control" required="enter"/>
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
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Giá</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="giaTien" type="text" name="txtemailcus" class="form-control" required="enter"/>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <b>Danh mục</b>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-line">
                                            <mvc:select path="tenTL" class="form-control show-tick">
                                                <option value="">-- Please select --</option>
                                                <mvc:options items="${listTL}"/>
                                            </mvc:select>
                                        </div>
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
                                        <b>Hình ảnh</b>
                                    </div>
                                    <div class="col-md-8">
                                        <mvc:input path="hinhAnhTam" type="hidden"/>
                                        <img src="/resources/img/widget/${SanPham.hinhAnh}" alt="" class="img-fluid img-35">
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-12 text-center">
                                        <div class="jumbotron">
                                            <h3>Upload images</h3>
                                            <p>(For quick upload and rendering, up to 5MB each.)</p>
                                            <mvc:input path="hinhAnh" type="file" class="form-control-file" id="exampleFormControlFile1"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <mvc:input type="hidden" path="id"/>
                                <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i>Lưu</button>
                                <button type="button" class="btn" data-dismiss="modal"><i class="fa fa-undo" aria-hidden="true"></i><a href="/admin/sanpham/list">Hủy</a></button>
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
