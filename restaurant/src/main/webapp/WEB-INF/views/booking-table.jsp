<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Order</title>
<link rel="stylesheet"
	href="<c:url value="../resources/css/booking-table.css"/>">
</head>

<body>
	<section id="reservation">
		<div class="container mt-2 mb-2 ">
			<h2 class="text-center pt-2 reservation-title">Make a
				reservation</h2>
			<!---Form-->
			<div class="reservation-content">
				<form class="mt-5" id="form-info">
					<div class="row">
						<div class="col-5">
							<div class="form-group">
								<label for="fullname">Họ và tên</label> <input type="text"
									class="form-control" id="fullname">
							</div>
							<div class="form-group">
								<label for="phone">Số điện thoại</label> <input type="tel"
									class="form-control" id="phone">
							</div>
						</div>
						<div class="col-5">
							<div class="form-group">
								<label for="date">Ngày</label> <input type="date"
									class="form-control" id="date">
							</div>
							<div class="form-group">
								<label for="time">Giờ</label> <input type="time"
									class="form-control" id="time">
							</div>
						</div>
					</div>
					<div class="row">
						<button class="btn mt-2" id="btn-next">Tiếp tục</button>
					</div>
				</form>
				<!---End Form-->
				<div id="choose-table">
					<div class="choose-table-container mt-5 mb-4">
						<c:forEach items="${listTables}" var="t">
							<c:choose>
								<c:when test="${t.getStatus() == 'deactivate'}">
									<div class="table-item disactive">${t.getId()}</div>
								</c:when>
								<c:otherwise>
									<div class="table-item">${t.getId()}</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
					<div class="row">
						<button class="btn mt-2 mr-4" id="btn-back">Quay về</button>
						<button class="btn solid col-2 mt-2">Đặt chổ</button>
					</div>
				</div>

			</div>

		</div>

	</section>
	<script>
        const btnNext = document.querySelector("#btn-next");
        const btnBack = document.querySelector("#btn-back");
        const formInfo = document.querySelector("#form-info");
        const listTables = document.querySelectorAll(".table-item");
        formInfo.addEventListener('submit',function(e){
            e.preventDefault();
        })
        const chooseTable = document.querySelector("#choose-table");
        btnNext.addEventListener('click',function(){
            formInfo.style.animation = 'floatLeft 0.5s forwards'
            chooseTable.style.animationDelay = '0.5s';
            chooseTable.style.animation = 'moveToLeft 0.5s forwards';
        })
        btnBack.addEventListener('click',function(){
            chooseTable.style.animation = 'moveToRight 0.5s forwards';
            formInfo.style.animationDelay = '0.5s';
            formInfo.style.animation = 'floatMain 0.5s forwards'
        })
        listTables.forEach(function(tableItem,index){
            tableItem.addEventListener('click',function(){
                if(!tableItem.classList.contains('disactive')){
                	const seletedTable = document.querySelector('.table-item.selected');
                	if(seletedTable != null)
                		document.querySelector('.table-item.selected').classList.remove('selected');
                    tableItem.classList.add('selected');
                }
            })
        })
    </script>
</body>

</html>