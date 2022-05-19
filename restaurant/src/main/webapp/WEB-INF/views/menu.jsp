<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hcmute.model.ProductModel" %>
<%@ page import="com.hcmute.model.CommentModel" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: hao_n
  Date: 5/19/2022
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <!-- Bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Font awesome cdn -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- custom css -->
    <link rel="stylesheet" href="<c:url value="../resources/css/homepage.css"/>">
</head>
<body>
<!-- navbar -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark" style="background-color: #006a31;">
    <div class="container">
        <a href="<c:url value="/"/>" class="navbar-brand d-flex justify-content-between align-items-center order-lg-0">
            <img src="<c:url value="../resources/images/restaurant-logo.png"/>" alt="logo">
            <span class = "text-uppercase fw-lighter ms-2">The Restaurant</span>
        </a>

        <div class="order-lg-2 nav-btns">
            <button type="button" class="btn position-relative">
                <i class="fa fa-shopping-cart" style="color: #fff"></i>
                <span class = "position-absolute top-0 start-100 translate-middle badge bg-danger">6</span>
            </button>
            <button type="button" class="btn position-relative">
                <i class="fa-solid fa-user" style="color: #fff"></i>
            </button>
            <button type="button" class="btn position-relative">
                <i class="fa fa-search" style="color: #fff"></i>
            </button>
        </div>

        <button class = "navbar-toggler border-0" type = "button" data-bs-toggle = "collapse" data-bs-target = "#navMenu">
            <span class = "navbar-toggler-icon"></span>
        </button>

        <div class = "collapse navbar-collapse order-lg-1" id = "navMenu">
            <ul class = "navbar-nav mx-auto text-center">
                <li class = "nav-item px-2 py-2">
                    <a class = "nav-link text-uppercase text-light" href = "#header">Home</a>
                </li>
                <li class = "nav-item px-2 py-2">
                    <a class = "nav-link text-uppercase text-light" href = "/menu">Menu</a>
                </li>
                <li class = "nav-item px-2 py-2">
                    <a class = "nav-link text-uppercase text-light" href = "<c:url value="/dat-cho"/>">Đặt bàn</a>
                </li>
                <li class = "nav-item px-2 py-2">
                    <a class = "nav-link text-uppercase text-light" href = "#about">Về chúng tôi</a>
                </li>
                <li class = "nav-item px-2 py-2 border-0">
                    <c:choose>
                        <c:when test="${sessionScope.account != null}">
                            <p class="nav-link text-uppercase text-light">
                                <c:out value="${sessionScope.account.username}" /></p>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${sessionScope.account == null}">
                            <a class = "nav-link text-uppercase text-light" href = "<c:url value="/login"/>">Đăng nhập/Đăng ký</a>
                        </c:when>
                    </c:choose>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- new menu -->
<c:choose>
    <c:when test="${requestScope.get('type') == 1}" >
        <section id = "new" class = "py-5">
            <div class = "container">
                <div class = "title text-center py-5">
                    <h2 class = "position-relative d-inline-block text-uppercase">Các món ăn mới nhất của nhà hàng</h2>
                </div>

                <div class = "special-list row g-0">
                    <%
                        ArrayList<ProductModel> list = (ArrayList<ProductModel>) request.getAttribute("listProducts");
                        for (ProductModel product:list) {%>
                    <div class = "col-md-6 col-lg-4 col-xl-3 p-2">
                        <div class = "special-img position-relative overflow-hidden">
                            <img src = "<c:url value="<%=product.getImg()%>" />" class = "w-100" alt="picture">
                        </div>
                        <div class = "text-center">
                            <p class = "text-capitalize mt-3 mb-1"><%=product.getName()%></p>
                            <span class = "fw-bold d-block"><%=product.getPrice()%>đ</span>
                            <a href = "/menu/view-product/<%=product.getId()%>" class = "btn btn-primary mt-3">View More</a>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
            </div>
        </section>
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${requestScope.get('type') == 2}">
        <section id = "new" class = "py-5">
            <div class = "container">
                <%
                    ProductModel product = (ProductModel) request.getAttribute("product");
                %>

                <div class = "title text-center py-5">
                    <h2 class = "position-relative d-inline-block text-uppercase"><%=product.getName().toUpperCase()%></h2>
                </div>

                <div class = "special-list row g-0">

                    <div class = "col-md-6 col-lg-4 col-xl-3 p-2">
                        <div class = "special-img position-relative overflow-hidden">
                            <img src = "<%=product.getImg()%>" class = "w-100" alt="picture">
                        </div>
                        <div class = "text-center">
                            <p class = "text-capitalize mt-3 mb-1"><%=product.getName()%></p>
                            <span class = "fw-bold d-block"><%=product.getPrice()%>đ</span>
                            <a href = "#" class = "btn btn-primary mt-3">Add To Basket</a>
                        </div>
                    </div>
                </div>

                <div class = "special-list row g-0">

                    <%
                        List<CommentModel> comments = (List<CommentModel>) request.getAttribute("comments");
                        for(CommentModel comment: comments){%>

                            <div class = "text-center">
                                <p class = "text-capitalize mt-3 mb-1"><%=comment.getComment()%></p>
                            </div>
                    <%}%>
                </div>

            </div>
        </section>
    </c:when>
</c:choose>

</body>
</html>
