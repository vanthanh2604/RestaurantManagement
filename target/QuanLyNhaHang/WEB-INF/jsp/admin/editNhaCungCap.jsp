<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
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
            <div id="AddProduct" tabindex="1" role="dialog" aria-hidden="false">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <mvc:form autocomplete="off" modelAttribute="nhacungcap" action="/admin/ncc/update" method="post" class="form-horizontal">
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
                                    <mvc:input type="hidden" path="id"/>
                                    <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save</button>
                                    <button type="button" class="btn" data-dismiss="modal"><i class="fa fa-undo" aria-hidden="true"></i><a href="/admin/ncc/list">Cance</a></button>
                                </div>
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
