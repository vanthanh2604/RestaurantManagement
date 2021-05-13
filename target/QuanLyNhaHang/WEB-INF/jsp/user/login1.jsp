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
                <h3>Trang đăng nhập</h3><br/>
                <p>${success}</p>
                <form action="/account/checklogin" method="post">
                <div class="form-group">
                    <input type="text" name="email" class="form-control" placeholder="Email" required="" value="">
                    <i class="ik ik-user"></i>
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Password" required="" value="">
                    <i class="ik ik-lock"></i>
                </div>
                <div class="row">
                    <div class="col text-left">
                        <label class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="item_checkbox" name="item_checkbox" value="option1">
                            <span class="custom-control-label">&nbsp;Remember Me</span>
                        </label>
                    </div>
                </div>
                <div class="sign-btn text-center">
                    <button type="submit" name="submit" class="btn btn-theme">Sign In</button>
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
