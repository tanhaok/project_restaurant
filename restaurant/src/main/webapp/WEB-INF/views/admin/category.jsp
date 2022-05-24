<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="url" value="/resources/admin"></c:url>

<%@include file="head.jsp" %>

<div class="container-fluid pt-4 px-4">
    <div class="bg-light text-center rounded p-4">
        <div class="table-responsive">
            <table id="myTable" class="table text-start align-middle table-bordered table-hover mb-0">
                <thead>
                <tr class="text-dark">
                    <th scope="col">Mã danh mục</th>
                    <th scope="col">Tên danh mục</th>

                    <th scope="col">Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="categories" items="${categories}">
                    <tr>
                        <td>${categories.id}</td>
                        <td>${categories.cusId}</td>


                        <td>
                            <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/admin/quan-ly-don-hang/view?id=${invoices.id}">Sửa</a>
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

