<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar pe-4 pb-3">
    <nav class="navbar bg-light navbar-light">
        <a href="<c:url value="/admin" />" class="navbar-brand mx-4 mb-3">
            <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>TRANG CHỦ</h3>
        </a>

        <div class="navbar-nav w-100">
            <a href="<c:url value="/admin"/>" class="nav-item nav-link ${active1}"><i class="fa fa-tachometer-alt me-2"></i>Trang chủ</a>
            <a href="<c:url value="/admin/quan-ly-don-hang/"/>" class="nav-item nav-link ${active2}"><i class="fa fa-th me-2"></i>Quản lý đơn hàng</a>
            <a href="<c:url value="/admin/quan-ly-tai-chinh/" />" class="nav-item nav-link ${active3}"><i class="fa fa-keyboard me-2"></i>Quản lý tài chính</a>
            <a href="<c:url value="/dat-cho"/>" class="nav-item nav-link ${active4}"><i class="fa fa-keyboard me-2"></i>Quản lý bàn</a>
            <a href="viewproduct" class="nav-item nav-link ${active5}"><i class="fa fa-keyboard me-2"></i>Product</a>
            <a href="viewemp" class="nav-item nav-link ${active6}"><i class="fa fa-keyboard me-2"></i>Employee</a>

        </div>
    </nav>
</div>

