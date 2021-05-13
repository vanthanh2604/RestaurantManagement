<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="/common/user/head.jsp"%>
<body>
<%@include file="/common/user/header.jsp"%>
<%@include file="/common/user/slider.jsp"%>
<section>
	<div class="container">
		<div class="row">
			<%@include file="/common/user/menu.jsp" %>
			<div class="col-sm-9 padding-right">
				<div class="features_items"><!--features_items-->
					<h2 class="title text-center">DANH SÁCH SẢN PHẨM</h2>
					<%@include file="danhSachSanPham.jsp"%>
				</div><!--features_items-->
			</div>
		</div>
	</div>
</section>

<!--/Footer-->
<%@include file="/common/user/footer.jsp"%>
</body>
</html>