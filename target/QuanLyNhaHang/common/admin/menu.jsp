<%@ page pageEncoding="UTF-8"%>
<div class="app-sidebar colored">
    <div class="sidebar-header">
        <a class="header-brand" href="/admin/dashboard">
                <span class="text">TRANG QUẢN TRỊ</span>
        </a>
        <button type="button" class="nav-toggle"><i data-toggle="expanded" class="ik ik-toggle-right toggle-icon"></i></button>
        <button id="sidebarClose" class="nav-close"><i class="ik ik-x"></i></button>
    </div>

    <div class="sidebar-content">
        <div class="nav-container">
            <nav id="main-menu-navigation" class="navigation-main">
                <div class="nav-item">
                    <a href="/admin/dashboard"><i class="ik ik-bar-chart-2"></i><span>Tổng quan</span></a>
                </div>
                <div class="nav-item">
                    <a href="/admin/danhmuc/list"><i class="ik ik-menu"></i><span>Quản lý danh mục</span></a>
                </div>
                <div class="nav-item">
                    <a href="/admin/sanpham/list"><i class="fa fa-list-alt"></i><span>Quản lý sản phẩm</span></a>
                </div>
                <div class="nav-item">
                    <a href="/admin/khuvuc/list"><i class="ik ik-menu"></i><span>Quản lý khu vực</span></a>
                </div>
                <div class="nav-item">
                    <a href="/admin/ban/list"><i class="fa fa-table"></i><span>Quản lý bàn</span></a>
                </div>
                <div class="nav-item">
                    <a href="/admin/dondatban/list"><i class="fa fa-users"></i><span>Quản lý đơn đặt bàn</span></a>
                </div>
                <div class="nav-item">
                    <a href="/admin/pos/table"><i class="fa fa-users"></i><span>Bán hàng</span></a>
                </div>
                <div class="nav-item">
                    <a href="/admin/invoice/list"><i class="fa fa-users"></i><span>Hóa đơn</span></a>
                </div>
                <div class="nav-item">
                    <a href="/admin/report/list"><i class="ik ik-bar-chart-2"></i><span>Báo cáo</span></a>
                </div>
            </nav>
        </div>
    </div>
</div>