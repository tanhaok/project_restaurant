<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="url" value="/WEB-INF/resources/admin"></c:url>

<%@include file="head.jsp" %>

<!-- Form Start -->
<div class="container-fluid pt-4 px-4">
    <div class="row g-4">

        <div class="bg-light rounded h-100 p-4">
            <h6 class="mb-4">Basic Form</h6>
            <form action="${pageContext.request.contextPath}/admin/quan-ly-don-hang/edit">
                <div class="mb-3">
                    <label for="id" class="form-label">Mã đơn hàng</label>
                    <input type="text" class="form-control" id="id" name="id" value="${invoice.id}"/>
                </div>
                <div class="mb-3">
                    <label for="cust_id" class="form-label">Mã khách hàng</label>
                    <input type="text" class="form-control" id="cust_id" name="cust_id" value="${invoice.cust_id}"/>
                </div>
                <div class="mb-3">
                    <label for="emp_id" class="form-label">Mã nhân viên</label>
                    <input type="text" class="form-control" id="emp_id" name="emp_id" value="${invoice.emp_id}"/>
                </div>
                <div class="mb-3">
                    <label for="cart_id" class="form-label">Mã giỏ hàng</label>
                    <input type="text" class="form-control" id="cart_id" name="cart_id" value="${invoice.cart_id}"/>
                </div>
                <div class="mb-3">
                    <label for="total_cost" class="form-label">Tổng cộng</label>
                    <input type="text" class="form-control" id="total_cost" name="total_cost" value="${invoice.total_cost}"/>
                </div>
                <div class="mb-3">
                    <label for="create_date" class="form-label">Ngày tạo</label>
                    <input type="date" class="form-control" id="create_date" name="create_date" value="${invoice.create_date}"/>
                </div>

                <button type="submit" class="btn btn-primary">Sửa</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="foot.jsp" %>
