<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="/common/user/head.jsp"%>
<body>
<%@include file="/common/user/header.jsp"%>
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-8">
                <h3>Trang đăng ký thành viên</h3><br/>
                <p>${alert}</p>
                <form action="/checkregist" method="post">
                    <div class="form-group">
                        <label>Nhập email:</label>
                        <input type="text" name="email" class="form-control" placeholder="Email" required="" value="">
                        <i class="ik ik-user"></i>
                    </div>
                    <div class="form-group">
                        <label>Họ tên:</label>
                        <input type="text" name="ten" class="form-control" placeholder="Họ tên" required="" value="">
                        <i class="ik ik-user"></i>
                    </div>
                    <div class="form-group">
                        <label>Nhập mật khẩu:</label>
                        <input type="password" name="password" class="form-control" placeholder="Mật khẩu" required="" value="">
                        <i class="ik ik-lock"></i>
                    </div>
                    <div class="form-group">
                        <label>Nhập lại mật khẩu:</label>
                        <input type="password" name="password2" class="form-control" placeholder="Nhập lại mật khẩu" required="" value="">
                        <i class="ik ik-lock"></i>
                    </div>
                    <div class="sign-btn text-center">
                        <button type="submit" name="submit" class="btn btn-theme">Đăng ký</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<!--/Footer-->
<%@include file="/common/user/footer.jsp"%>
</body>
</html>
