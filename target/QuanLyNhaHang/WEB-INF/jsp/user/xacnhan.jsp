<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="/common/user/head.jsp"%>
<body>
<%@include file="/common/user/header.jsp"%>

<section id="cart_items">
    <div class="container">
        <div class="row">
            <div class="col-1">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="#">Trang chủ</a></li>
                        <li class="active">Xác nhận</li>
                    </ol>
                </div>
            </div>
            <div class="col-sm-8">
                <h3>Xác nhận đơn đặt bàn</h3>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed" style="width: 95%;margin-left: 10px;margin-top: 5px">
                        <thead>
                        <tr class="cart_menu">
                            <td>ID</td>
                            <td>Tên sản phẩm</td>
                            <td>Hình ảnh</td>
                            <td>Giá</td>
                            <td>Số lượng</td>
                            <td>Số tiền</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${sessionScope['scopedTarget.cartService'].items}">
                            <tr data-id="${item.id}" data-price="${item.giaTien}">
                                <td>
                                    <p>${item.id}</p>
                                </td>
                                <td>
                                    <p>${item.tenSP}</p>
                                </td>
                                <td>
                                    <a href=""><img height="50px" width="60px" src="/resources/img/widget/${item.hinhAnh}" alt=""></a>
                                </td>
                                <td>
                                    <p>${item.giaTien}</p>
                                </td>
                                <td>
                                    <p>${item.soLuong}</p>
                                </td>
                                <td>
                                    <p class="amt">${item.soLuong * item.giaTien} VNĐ</p>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:set var="cart" value="${sessionScope['scopedTarget.cartService']}"/>
                        <tr>
                            <td><b>Tổng tiền</b></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><b id="totalbill">${cart.amount}</b> VNĐ</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-sm-3">
                <h3 style="margin-top: 0;height: 50px;padding-top: 10px;color: white;text-align: center;background-color: #d9534f">THÔNG TIN ĐÃ ĐIỀN</h3>
                <p><b> Số điện thoại:</b>    ${dondatban.sdt}</p>
                <p><b> Ngày đặt:</b>    ${dondatban.ngayDatBan}</p>
                <p><b>Số người:</b>    ${dondatban.soNguoi} người</p>
                <p></p>
                <a href="/datban/xacnhan" class="btn btn-sm btn-danger" style="margin:0 0 15px 15px; width: 90%;height: 50px">Xác nhận đặt bàn</a>
            </div>
        </div>

    </div>
</section> <!--/#cart_items-->

<!--/Footer-->
<%@include file="/common/user/footer.jsp"%>
<%--<script>--%>
<%--    function thongbao(){--%>
<%--        if(confirm("Bấm vào nút OK để xác nhận") == true){--%>
<%--            window.location="/datban/xacnhan"--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>