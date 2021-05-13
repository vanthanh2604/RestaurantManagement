<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="/common/admin/head.jsp"%>
<body>
<div class="wrapper">
	<%@include file="/common/admin/header.jsp"%>
	<div class="page-wrap">
		<%@include file="/common/admin/menu.jsp"%>
		<div class="main-content">
			<h3 class="mb-5 text-dark">Chào mừng ${sessionScope.username}</h3>
			<div class="container-fluid">
				<div class="row clearfix">
					<div class="col-xl-3 col-md-6">
						<div class="card prod-p-card card-red">
							<div class="card-body">
								<div class="row align-items-center mb-30">
									<div class="col">
										<h6 class="mb-5 text-white">Tổng số bàn</h6>
										<h3 class="mb-0 fw-700 text-white">${totalTable}</h3>
									</div>
									<div class="col-auto">
										<i class="fa fa-cube text-red f-18"></i>
									</div>
								</div>
								<p class="mb-0 text-white"><span class="label label-danger mr-10">+11%</span>From Previous Month</p>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card prod-p-card card-blue">
							<div class="card-body">
								<div class="row align-items-center mb-30">
									<div class="col">
										<h6 class="mb-5 text-white">Tổng hóa đơn</h6>
										<h3 class="mb-0 fw-700 text-white">${totalInvoice}</h3>
									</div>
									<div class="col-auto">
										<i class="fas fa-database text-blue f-18"></i>
									</div>
								</div>
								<p class="mb-0 text-white"><span class="label label-primary mr-10">+12%</span>From Previous Month</p>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card prod-p-card card-green">
							<div class="card-body">
								<div class="row align-items-center mb-30">
									<div class="col">
										<h6 class="mb-5 text-white">Tổng doanh thu</h6>
										<h3 class="mb-0 fw-700 text-white">${total_revenue}</h3>
									</div>
									<div class="col-auto">
										<i class="fas fa-dollar-sign text-green f-18"></i>
									</div>
								</div>
								<p class="mb-0 text-white"><span class="label label-success mr-10">+52%</span>From Previous Month</p>
							</div>
						</div>
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