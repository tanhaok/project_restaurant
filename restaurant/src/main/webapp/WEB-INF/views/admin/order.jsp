<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="url" value="/WEB-INF/resources/admin"></c:url>

<%@include file="head.jsp" %>

<div class="container-fluid pt-4 px-4">
    <div class="bg-light text-center rounded p-4">
        <div class="table-responsive">
            <table id="myTable" class="table text-start align-middle table-bordered table-hover mb-0">
                <thead>
                <tr class="text-dark">
                    <th scope="col">Mã đơn hàng</th>
                    <th scope="col">Mã khách hàng</th>
                    <th scope="col">Mã nhân viên</th>
                    <th scope="col">Mã giỏ hàng</th>
                    <th scope="col">Tổng cộng</th>
                    <th scope="col">Ngày tạo</th>

                    <th scope="col">Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="invoices" items="${invoices}">
                    <tr>
                        <td>${invoices.id}</td>
                        <td>${invoices.cust_id}</td>
                        <td>${invoices.emp_id}</td>
                        <td>${invoices.cart_id}</td>
                        <td>${invoices.total_cost}</td>
                        <td>${invoices.create_date}</td>

                        <td>
                            <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/admin/quan-ly-don-hang/edit?id=${invoices.id}">Sửa</a>
                            <a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/admin/quan-ly-don-hang/delete/${invoices.id}">Xoá</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="foot.jsp" %>

