<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="/common/user/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<%@include file="/common/user/header.jsp"%>


    <section id="cart_items">
        <div class="container">
            <div class="row">
                <div class="col-1">
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="#">Trang chủ</a></li>
                            <li class="active">Giỏ hàng</li>
                        </ol>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="table-responsive cart_info">
                        <h3></h3>
                    <table class="table table-condensed" style="width: 95%;margin-left: 10px;margin-top: 5px">
                        <thead>
                            <tr class="cart_menu">
                                <td>ID</td>
                                <td>Tên sản phẩm</td>
                                <td>Hình ảnh</td>
                                <td>Giá</td>
                                <td>Số lượng</td>
                                <td>Số tiền</td>
                                <td></td>
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
                                <input value="${item.soLuong}" type="number" min="1" style="width: 70px">
                            </td>
                            <td>
                                <p class="amt">${item.soLuong * item.giaTien} VNĐ</p>
                            </td>
                            <td class="cart_delete">
                                <a class="cart_quantity_delete click-remove-p" href=""><i class="fa fa-times"></i></a>
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
                    <button class="btn btn-sm btn-danger click-clear">Xóa tất cả</button>
                    <a href="/" class="btn btn-sm btn-info">Tiếp tục</a>
                </div>
                <div class="col-sm-3">
                        <h3 style="margin-top: 0;height: 50px;padding-top: 10px;color: white;text-align: center;background-color: #d9534f">ĐẶT BÀN NGAY</h3>
                        <mvc:form modelAttribute="dondatban" action="/datban" method="post">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <mvc:input path="sdt" placeholder="Số điện thoại" type="text" class="form-control" required="enter"/>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <mvc:select path="soNguoi" class="form-control">
                                            <mvc:option value="1" label="1 Người"/>
                                            <mvc:option value="2" label="2 Người"/>
                                            <mvc:option value="3" label="3 Người"/>
                                            <mvc:option value="4" label="4 Người"/>
                                            <mvc:option value="5" label="5 Người"/>
                                            <mvc:option value="6" label="6 Người"/>
                                            <mvc:option value="7" label="7 Người"/>
                                            <mvc:option value="8" label="8 Người"/>
                                            <mvc:option value="9" label="9 Người"/>
                                            <mvc:option value="10" label="10 Người"/>
                                        </mvc:select>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <mvc:input path="ngayDatBan" placeholder="Ngày đặt" type="date" class="form-control" required="enter"/>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input id="time" name="ngayDatBan" placeholder="Ngày đặt" type="time" class="form-control" value="" required="enter">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <mvc:textarea path="ghiChu" placeholder="Lời nhắn" class="form-control" rows="5" cols="30" required="enter"></mvc:textarea>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-sm btn-danger" style="margin:0 0 15px 15px; width: 90%;height: 50px">Đặt bàn</button>
                            </div>
                        </mvc:form>
                    </div>
                </div>

        </div>
    </section> <!--/#cart_items-->

<!--/Footer-->
<%@include file="/common/user/footer.jsp"%>
<script>
    function thongbao(){
        if(confirm("Bấm vào nút OK để xác nhận") == true){
            window.location.href="/"
            alert("Đặt bàn thành công!")
        }else{
            alert("Đã hủy đặt bàn!")
        }
    }
</script>
</body>
</html>