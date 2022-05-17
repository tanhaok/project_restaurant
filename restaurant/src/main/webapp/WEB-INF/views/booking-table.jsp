<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/booking-table.css"/>">
    <title>Quản lý bàn</title>
</head>
<body>
    <section id="table-management" class="container d-flex align-content-center flex-column pt-3 pb-3">
        <h2 class="text-center mt-2 mb-5">Quản lý bàn</h2>
        <div class="choose-table-container">
        <c:forEach items="${listTables}" var="t">
            <c:choose>
                <c:when test="${t.getStatus() == 'deactivate'}">
                    <div class="table-item disactive" data-toggle="modal" data-target="#myModal" data-id="${t.getId()}">
                    ${t.getId()}
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="table-item" data-toggle="modal" data-target="#myModal" data-id="${t.getId()}">
                    ${t.getId()}
                    </div>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        </div>
    </section>
    <!-- Button trigger modal -->

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
        aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Thông tin khách hàng</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="form-info" action="/booking-table">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="fullname">Họ và tên</label>
                                    <input type="text" class="form-control" id="fullname">
                                </div>
                                <div class="form-group">
                                    <label for="phone">Số điện thoại</label>
                                    <input type="tel" class="form-control" id="phone">
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="date">Ngày</label>
                                    <input type="date" class="form-control" id="date">
                                </div>
                                <div class="form-group">
                                    <label for="time">Giờ</label>
                                    <input type="time" class="form-control" id="time">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                            <button type="submit" class="btn btn-primary">Lưu</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <!--JS-->
    <script>
        const formInfo = document.querySelector("#form-info");
        formInfo.addEventListener('submit',function(e){
            e.preventDefault();
            var tableID = document.querySelector('.table-item.selected').dataset.id;
            var action = formInfo.getAttribute("action");
            formInfo.setAttribute('action',action+`/${tableID}`);
            formInfo.submit();
        })
        const listTables = document.querySelectorAll(".table-item");
        listTables.forEach((tableItem, index) => {
            tableItem.addEventListener('click', () => {
                if (!tableItem.classList.contains('disactive')) {
                    var selectedTable = document.querySelector('.table-item.selected');
                    selectedTable && selectedTable.classList.remove('selected');
                    tableItem.classList.add('selected');
                }
            })
        })
    </script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>